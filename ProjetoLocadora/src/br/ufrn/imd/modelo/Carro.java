package br.ufrn.imd.modelo;

public class Carro extends Veiculo{
	private int id_carro;
	private int id_veiculo;
	private int portas;
	private int potencia;
	
	public int getId_carro() {
		return id_carro;
	}
	public int getId_veiculo() {
		return id_veiculo;
	}
	public int getPortas() {
		return portas;
	}
	public int getPotencia() {
		return potencia;
	}
	public void setId_veiculo(int id_veiculo) {
		this.id_veiculo = id_veiculo;
	}
	public void setId_carro(int id_carro) {
		this.id_carro = id_carro;
	}
	public void setPortas(int portas) {
		this.portas = portas;
	}
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	
	
	
	
}
