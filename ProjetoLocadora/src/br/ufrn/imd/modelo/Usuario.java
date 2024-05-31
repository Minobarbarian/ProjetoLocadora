package br.ufrn.imd.modelo;

import java.time.LocalDate;

public class Usuario {
	protected String nome;
	protected String login;
	protected String senha;
	protected String email;
	protected String telefone;
	protected LocalDate dataNascimento;
	protected Endereco endereco;
	
	public String getNome() {
		return nome;
	}
	public String getLogin() {
		return login;
	}
	public String getSenha() {
		return senha;
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
	public String getEmail() {
		return email;
	}
	public String getTelefone() {
		return telefone;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public Endereco getEndereco() {
		return endereco;
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
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
