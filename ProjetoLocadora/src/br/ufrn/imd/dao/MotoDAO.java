package br.ufrn.imd.dao;

import java.util.ArrayList;
import java.util.Optional;

import br.ufrn.imd.modelo.Moto;

public class MotoDAO {
	private ArrayList<Moto> motos;
	private static MotoDAO mDAO;
	
	public MotoDAO() {
		motos = new ArrayList<Moto>();
	}
	
	public static MotoDAO getInstance() {
		if(mDAO == null) {
			mDAO = new MotoDAO();
		}
		return mDAO;
	}
	
	public void addMoto(Moto m) {
		motos.add(m);
		System.out.println("Moto "+m.getMarca()+" inserida!!!");
	}
	
	public void registrarMotos() {
		
	}

	public Moto getMoto(String placa, String marca) {
		Optional<Moto> moto_encontrada =  motos.stream()
				.filter(m -> m.getPlaca().equals(placa) && m.getMarca().equals(marca))
				.findFirst();
		return moto_encontrada.orElse(null);
	}
}
