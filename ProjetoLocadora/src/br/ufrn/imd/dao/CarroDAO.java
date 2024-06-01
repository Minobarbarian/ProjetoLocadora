package br.ufrn.imd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ufrn.imd.controle.Banco_de_Dados;
import br.ufrn.imd.modelo.Carro;

import br.ufrn.imd.modelo.Carro;

public class CarroDAO {
	private static CarroDAO cDAO;
	private Connection connection;
	
	
	public CarroDAO() {
		connection = Banco_de_Dados.getConnection();
	}
	
	public static CarroDAO getInstance() {
		if(cDAO == null) {
			cDAO = new CarroDAO();
		}
		return cDAO;
	}
	
	//CREATE
	public void criarCarro(Carro carro) {
		String sql = "INSERT INTO carros (IdVeiculo, portas, potencia) VALUES (?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, carro.getId_veiculo());
			statement.setInt(2, carro.getPortas());
			statement.setInt(3, carro.getPotencia());
			statement.executeUpdate();
			
			System.out.println("Carro inserido!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//READ
	public Carro pegarCarro(String marca, String placa) {
		String sql = "SELECT * FROM carros INNER JOIN veiculos ON carros.idVeiculo = veiculos.idVeiculo WHERE veiculos.marca = ? AND veiculos.placa = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, marca);
            statement.setString(2, placa);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                	Carro carro = new Carro();
                	carro.setId_carro(resultSet.getInt("idCarro"));
                	carro.setId_veiculo(resultSet.getInt("idVeiculo"));
                	carro.setPortas(resultSet.getInt("portas"));
                	carro.setPotencia(resultSet.getInt("potencia"));
                    
                    System.out.println("Carro encontrado!!!");
                    return carro;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Carro não encontrado!!!");
        return null;
	}
	
	//UPDATE
	public void atualizarCarro(Carro carro) {
		String sql = "UPDATE carros SET portas = ?, potencia = ? WHERE idCarro = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, carro.getPortas());
            statement.setInt(2, carro.getPotencia());
            statement.setInt(3, carro.getId_carro());
            statement.executeUpdate();
            
            System.out.println("Carro atualizado!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	//DELETE
	public void deletarCarro(int id_carro) {
		String sql = "DELETE FROM carros WHERE idCarro = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_carro);
            int rowsDeleted = statement.executeUpdate();
            
            System.out.print("Carro");
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
