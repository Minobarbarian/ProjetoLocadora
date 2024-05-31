package br.ufrn.imd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ufrn.imd.controle.Banco_de_Dados;
import br.ufrn.imd.modelo.Moto;

public class MotoDAO {
	private static MotoDAO mDAO;
	private Connection connection;
	
	
	public MotoDAO() throws SQLException {
		connection = Banco_de_Dados.getConnection();
	}
	
	public static MotoDAO getInstance() throws SQLException {
		if(mDAO == null) {
			mDAO = new MotoDAO();
		}
		return mDAO;
	}
	
	//CREATE
	public void criarMoto(Moto moto) {
		String sql = "INSERT INTO Motos (IdMoto, IdVeiculo, cilindradas, partida) VALUES (?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, moto.getId_moto());
			statement.setInt(2, moto.getId_veiculo());
			statement.setInt(3, moto.getCilindradas());
			statement.setString(4, moto.getPartida());
			statement.executeUpdate();
			
			System.out.println("Moto inserida!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//READ
	public Moto pegarMoto(String marca, String placa) {
		String sql = "SELECT * FROM Motos INNER JOIN Veiculos ON Motos.idVeiculo = Veiculos.idVeiculo WHERE Veiculos.marca = ? AND Veiculos.placa = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, marca);
            statement.setString(2, placa);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                	Moto moto = new Moto();
                	moto.setId_moto(resultSet.getInt("idMoto"));
                	moto.setId_veiculo(resultSet.getInt("idVeiculo"));
                	moto.setCilindradas(resultSet.getInt("cilindradas"));
                	moto.setPartida(resultSet.getString("partida"));
                    
                    System.out.println("Moto encontrada!!!");
                    return moto;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Moto não encontrada!!!");
        return null;
	}
	
	//UPDATE
	public void atualizarMoto(Moto moto) {
		String sql = "UPDATE Motos SET cilindradas = ?, partida = ? WHERE idMoto = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, moto.getCilindradas());
            statement.setString(2, moto.getPartida());
            statement.setInt(3, moto.getId_moto());
            statement.executeUpdate();
            
            System.out.println("Moto atualizada!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	//DELETE
	public void deletarMoto(int id_moto) {
		String sql = "DELETE FROM Motos WHERE idMoto = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_moto);
            int rowsDeleted = statement.executeUpdate();
            System.out.print("Moto");
            if (rowsDeleted > 0) {
                System.out.println(" deletada do banco de dados!!!");
            } else {
                System.out.println(" não encontrada!!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
