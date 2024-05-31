package br.ufrn.imd.modelo;

public class Moto extends Veiculo{
	private int id_moto;
	private int id_veiculo;
	private int cilindradas;
	private String partida;
	
	public int getId_moto() {
		return id_moto;
	}
	public int getId_veiculo() {
		return id_veiculo;
	}
	public int getCilindradas() {
		return cilindradas;
	}
	public String getPartida() {
		return partida;
	}
	public void setId_moto(int id_moto) {
		this.id_moto = id_moto;
	}
	public void setId_veiculo(int id_veiculo) {
		this.id_veiculo = id_veiculo;
	}
	public void setCilindradas(int cilindradas) {
		this.cilindradas = cilindradas;
	}
	public void setPartida(String partida) {
		this.partida = partida;
	}
	
	
}
