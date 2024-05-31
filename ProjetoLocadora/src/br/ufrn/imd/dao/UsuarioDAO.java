package br.ufrn.imd.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ufrn.imd.controle.Banco_de_Dados;
import br.ufrn.imd.modelo.Usuario;

public class UsuarioDAO {
	private static UsuarioDAO uDAO;
	private Connection connection;
	
	
	public UsuarioDAO() throws SQLException {
		connection = Banco_de_Dados.getConnection();
	}
	
	public static UsuarioDAO getInstance() throws SQLException {
		if(uDAO == null) {
			uDAO = new UsuarioDAO();
		}
		return uDAO;
	}
	
	//CREATE
	public void criarUsuario(Usuario usuario) {
		String sql = "INSERT INTO Usuarios (idUsuario, idEndereco, nome, login, senha, email, telefone, data_nascimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, usuario.getId_usuario());
			statement.setInt(2, usuario.getId_endereco());
			statement.setString(3, usuario.getNome());
			statement.setString(4, usuario.getLogin());
			statement.setString(5, usuario.getSenha());
			statement.setString(6, usuario.getEmail());
			statement.setString(7, usuario.getTelefone());
			statement.setDate(8, Date.valueOf(usuario.getDataNascimento()));
			statement.executeUpdate();
			
			System.out.println("Usuario "+usuario.getNome()+" inserido!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//READ
	public Usuario pegarUsuario(String login, String senha) {
		String sql = "SELECT * FROM Usuarios WHERE login = ? AND senha = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, login);
            statement.setString(2, senha);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                	Usuario usuario = new Usuario();
                	usuario.setId_usuario(resultSet.getInt("idUsuario"));
                	usuario.setId_endereco(resultSet.getInt("idEndereco"));
                	usuario.setNome(resultSet.getString("nome"));
                	usuario.setNome(resultSet.getString("login"));
                	usuario.setNome(resultSet.getString("senha"));
                	usuario.setNome(resultSet.getString("email"));
                	usuario.setNome(resultSet.getString("telefone"));
        			usuario.setDataNascimento(resultSet.getDate("data_nascimento").toLocalDate());
                	
                    System.out.println("Usuario " + usuario.getNome() + " encontrado!!!");
                    return usuario;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Usuario não encontrado!!!");
        return null;
	}
	
	//UPDATE
	public void atualizarUsuario(Usuario usuario) {
		String sql = "UPDATE Usuarios SET nome = ?, login = ?, senha = ?, email = ?, telefone = ?, data_nascimento = ? WHERE idUsuario = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getLogin());
            statement.setString(3, usuario.getSenha());
            statement.setString(4, usuario.getEmail());
            statement.setString(4, usuario.getTelefone());
            statement.setDate(5, Date.valueOf(usuario.getDataNascimento()));
            statement.setInt(6, usuario.getId_usuario());
            statement.executeUpdate();
            
            System.out.println("Usuario " + usuario.getNome() + " atualizado!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	//DELETE
	public void deletarUsuario(int id_usuario) {
		String sql = "DELETE FROM Usuarios WHERE idUsuario = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_usuario);
            int rowsDeleted = statement.executeUpdate();
            
            System.out.print("Usuario");
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
