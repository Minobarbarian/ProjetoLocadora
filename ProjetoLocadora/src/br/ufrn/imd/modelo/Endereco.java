package br.ufrn.imd.modelo;

public class Endereco {
	protected int id_endereco;
	protected String rua;
	protected String cidade;
	protected String estado;
	protected String cep;
	
	public int getId_endereco() {
		return id_endereco;
	}
	public String getRua() {
		return rua;
	}
	public String getCidade() {
		return cidade;
	}
	public String getEstado() {
		return estado;
	}
	public String getCep() {
		return cep;
	}
	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
}
