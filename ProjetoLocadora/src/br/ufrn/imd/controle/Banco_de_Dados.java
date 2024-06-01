package br.ufrn.imd.controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco_de_Dados {
	private static final String URL = "jdbc:mysql://localhost:3306/locadora";
	private static final String NOME = "root";
	private static final String SENHA = "root";
	
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection(URL, SENHA, NOME);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Conexão falhou");
		}
	}
}
