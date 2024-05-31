package br.ufrn.imd.dao;

import java.util.ArrayList;
import java.util.Optional;

import br.ufrn.imd.modelo.Carro;

public class CarroDAO {
	private ArrayList<Carro> carros;
	private static CarroDAO cDAO;
	
	public CarroDAO() {
		carros = new ArrayList<Carro>();
	}
	
	public static CarroDAO getInstance() {
		if(cDAO == null) {
			cDAO = new CarroDAO();
		}
		return cDAO;
	}
	
	public void addCarro(Carro c) {
		carros.add(c);
		System.out.println("Carro "+c.getMarca()+" inserido!!!");
	}
	
	public void registrarCarros() {
		
	}

	public Carro getCarro(String placa, String marca) {
		Optional<Carro> carro_encontrado = carros.stream()
				.filter(c -> c.getPlaca().equals(placa) && c.getMarca().equals(marca))
				.findFirst();
		return carro_encontrado.orElse(null);
	}
}
