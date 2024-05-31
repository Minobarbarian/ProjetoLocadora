package br.ufrn.imd.dao;

import java.util.ArrayList;
import java.util.Optional;

import br.ufrn.imd.modelo.Usuario;

public class UsuarioDAO {
	private ArrayList<Usuario> usuarios;
	private static UsuarioDAO uDAO;
	
	public UsuarioDAO() {
		usuarios = new ArrayList<Usuario>();
	}
	
	public static UsuarioDAO getInstance() {
		if(uDAO == null) {
			uDAO = new UsuarioDAO();
		}
		return uDAO;
	}
	
	public void addUsuario(Usuario u) {
		usuarios.add(u);
		System.out.println("Usuário "+u.getNome()+" inserido!!!");
	}
	
	public void registrarUsuarios() {
		
	}

	public Usuario getUsuario(String login, String senha) {
		Optional<Usuario> usuario_encontrado =  usuarios.stream()
				.filter(u -> u.getLogin().equals(login) && u.getSenha().equals(senha))
				.findFirst();
		return usuario_encontrado.orElse(null);
	}
}
