package br.ufrn.imd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import br.ufrn.imd.controle.Banco_de_Dados;
import br.ufrn.imd.modelo.Admin;

public class AdminDAO {
	private static AdminDAO aDAO;
	private Connection connection;
	
	
	public AdminDAO() throws SQLException {
		connection = Banco_de_Dados.getConnection();
	}
	
	public static AdminDAO getInstance() throws SQLException {
		if(aDAO == null) {
			aDAO = new AdminDAO();
		}
		return aDAO;
	}
	
	//CREATE
	public void addAdmin(Admin a) {
		String sql = "INSERT INTO Admins (cargo, supervisor, departamento) VALUES (?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, a.getCargo());
			statement.setString(2, a.getSupervisor());
			statement.setString(3, a.getDepartamento());
			statement.executeUpdate();
			System.out.println("Administrador "+a.getNome()+" inserido!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//READ
	public Admin getAdmin(String login, String senha) {
		String sql = "SELECT * FROM Admins WHERE login = ? AND senha = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, login);
            statement.setString(2, senha);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Admin admin = new Admin();
                    admin.setNome(resultSet.getString("nome"));
                    admin.setLogin(resultSet.getString("login"));
                    admin.setSenha(resultSet.getString("senha"));
                    System.out.println("Admin " + admin.getNome() + " encontrado!!!");
                    return admin;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Admin não encontrado!!!");
        return null;
	}
	
	//UPDATE
	public void updateAdmin(Admin admin) {
		String sql = "UPDATE Admins SET cargo = ?, supervisor = ?, departamento = ? WHERE login = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, admin.getCargo());
            statement.setString(2, admin.getSupervisor());
            statement.setString(3, admin.getDepartamento());
            statement.setString(4, admin.getLogin());
            statement.executeUpdate();
            System.out.println("Admin " + admin.getNome() + " atualizado!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	//DELETE
	public void deleteAdmin(Admin admin) {
		String sql = "DELETE FROM Admins WHERE login = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, admin.getLogin());
            int rowsDeleted = statement.executeUpdate();
            System.out.print("Admin " + admin.getLogin());
            if (rowsDeleted > 0) {
                System.out.println(" deletado do banco de dados!!!");
            } else {
                System.out.println(" não encontrado!!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
