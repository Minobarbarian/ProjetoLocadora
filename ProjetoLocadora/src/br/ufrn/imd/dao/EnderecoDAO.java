package br.ufrn.imd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ufrn.imd.controle.Banco_de_Dados;
import br.ufrn.imd.modelo.Endereco;

public class EnderecoDAO {
	private static EnderecoDAO eDAO;
	private Connection connection;
	
	
	public EnderecoDAO() {
		connection = Banco_de_Dados.getConnection();
	}
	
	public static EnderecoDAO getInstance() {
		if(eDAO == null) {
			eDAO = new EnderecoDAO();
		}
		return eDAO;
	}
	
	//CREATE
	public void criarEndereco(Endereco end) {
		String sql = "INSERT INTO Enderecos (rua, cep, cidade, estado) VALUES (?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, end.getRua());
			statement.setString(2, end.getCep());
			statement.setString(3, end.getCidade());
			statement.setString(4, end.getEstado());
			statement.executeUpdate();
			System.out.println("Endereço "+end.getCep()+" inserido!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//READ
	public Endereco pegarEndereco(String cep, String estado) {
		String sql = "SELECT * FROM Enderecos WHERE cep = ? AND estado = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cep);
            statement.setString(2, estado);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                	Endereco end = new Endereco();
                	end.setId_endereco(resultSet.getInt("idEndereco"));
                	end.setRua(resultSet.getString("rua"));
                    end.setCep(resultSet.getString("cep"));
                    end.setCidade(resultSet.getString("cidade"));
                    end.setEstado(resultSet.getString("estado"));
                    System.out.println("Endereço " + end.getCep() + " encontrado!!!");
                    return end;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Endereço não encontrado!!!");
        return null;
	}
	
	//UPDATE
	public void atualizarEndereco(Endereco end) {
		String sql = "UPDATE Enderecos SET rua = ?, cep = ?, cidade = ?, estado = ? WHERE idEndereco = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, end.getRua());
            statement.setString(2, end.getCep());
            statement.setString(3, end.getCidade());
            statement.setString(4, end.getEstado());
            statement.setInt(5, end.getId_endereco());
            statement.executeUpdate();
            System.out.println("Endereço " + end.getCep() + " atualizado!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	//DELETE
	public void deletarEndereco(int id_endereco) {
		String sql = "DELETE FROM Enderecos WHERE idEndereco = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_endereco);
            int rowsDeleted = statement.executeUpdate();
            System.out.print("Endereco");
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
