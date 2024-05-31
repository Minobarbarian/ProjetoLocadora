package br.ufrn.imd.modelo;

import java.time.LocalDate;

public class Usuario {
	protected int id_usuario;
	protected int id_endereco;
	protected String nome;
	protected String login;
	protected String senha;
	protected String email;
	protected String telefone;
	protected LocalDate dataNascimento;
	
	public int getId_usuario() {
		return id_usuario;
	}
	public int getId_endereco() {
		return id_endereco;
	}
	public String getNome() {
		return nome;
	}
	public String getLogin() {
		return login;
	}
	public String getSenha() {
		return senha;
	}
	public String getEmail() {
		return email;
	}
	public String getTelefone() {
		return telefone;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
