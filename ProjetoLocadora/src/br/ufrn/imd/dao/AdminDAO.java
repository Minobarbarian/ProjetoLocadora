package br.ufrn.imd.dao;

import java.util.ArrayList;
import java.util.Optional;

import br.ufrn.imd.modelo.Admin;

public class AdminDAO {
	private ArrayList<Admin> administradores;
	private static AdminDAO aDAO;
	
	public AdminDAO() {
		administradores = new ArrayList<Admin>();
	}
	
	public static AdminDAO getInstance() {
		if(aDAO == null) {
			aDAO = new AdminDAO();
		}
		return aDAO;
	}
	
	public void addAdmin(Admin a) {
		administradores.add(a);
		System.out.println("Administrador "+a.getNome()+" inserido!!!");
	}
	
	public void registrarAdmins() {
		
	}

	public Admin getAdmin(String login, String senha) {
		Optional<Admin> admin_encontrado =  administradores.stream()
				.filter(a -> a.getLogin().equals(login) && a.getSenha().equals(senha))
				.findFirst();
		return admin_encontrado.orElse(null);
	}
}
