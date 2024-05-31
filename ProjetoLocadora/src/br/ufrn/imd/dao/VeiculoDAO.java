package br.ufrn.imd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ufrn.imd.controle.Banco_de_Dados;
import br.ufrn.imd.modelo.Veiculo;

public class VeiculoDAO {
	private static VeiculoDAO vDAO;
	private Connection connection;
	
	
	public VeiculoDAO() throws SQLException {
		connection = Banco_de_Dados.getConnection();
	}
	
	public static VeiculoDAO getInstance() throws SQLException {
		if(vDAO == null) {
			vDAO = new VeiculoDAO();
		}
		return vDAO;
	}
	
	//CREATE
	public void criarVeiculo(Veiculo veiculo) {
		String sql = "INSERT INTO Veiculos (idVeiculo, quilometragem, valor_aluguel, marca, placa, alugado) VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, veiculo.getId_veiculo());
			statement.setInt(2, veiculo.getQuilometragem());
			statement.setDouble(3, veiculo.getValorAluguel());
			statement.setString(4, veiculo.getMarca());
			statement.setString(5, veiculo.getPlaca());
			statement.setInt(6, veiculo.getAlugado());
			statement.executeUpdate();
			
			System.out.println("Veiculo inserido!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//READ
	public Veiculo pegarVeiculo(String marca, String placa) {
		String sql = "SELECT * FROM Veiculos WHERE login = ? AND senha = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, marca);
            statement.setString(2, placa);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                	Veiculo Veiculo = new Veiculo();
                	Veiculo.setId_veiculo(resultSet.getInt("idVeiculo"));
                	Veiculo.setQuilometragem(resultSet.getInt("quilometragem"));
                	Veiculo.setValorAluguel(resultSet.getDouble("valor_aluguel"));
                	Veiculo.setMarca(resultSet.getString("marca"));
                	Veiculo.setPlaca(resultSet.getString("placa"));
                	Veiculo.setAlugado(resultSet.getInt("alugado"));
                	
                    System.out.println("Veiculo encontrado!!!");
                    return Veiculo;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Veiculo não encontrado!!!");
        return null;
	}
	
	//UPDATE
	public void atualizarVeiculo(Veiculo veiculo) {
		String sql = "UPDATE Veiculos SET quilometragem = ?, valor_aluguel = ?, marca = ?, placa = ?, alugado = ? WHERE idVeiculo = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, veiculo.getQuilometragem());
            statement.setDouble(2, veiculo.getValorAluguel());
            statement.setString(3, veiculo.getMarca());
            statement.setString(4, veiculo.getPlaca());
            statement.setInt(4, veiculo.getAlugado());
            statement.setInt(5, veiculo.getId_veiculo());
            statement.executeUpdate();
            
            System.out.println("Veiculo atualizado!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	//DELETE
	public void deletarVeiculo(int id_veiculo) {
		String sql = "DELETE FROM Veiculos WHERE idVeiculo = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_veiculo);
            int rowsDeleted = statement.executeUpdate();
            
            System.out.print("Veiculo");
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
