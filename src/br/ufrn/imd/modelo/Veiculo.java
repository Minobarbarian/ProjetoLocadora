package br.ufrn.imd.modelo;

public class Veiculo {
	protected boolean alugado;
	protected String marca;
	protected String placa;
	protected double valorAluguel;
	protected int Quilometragem;
	
	public Veiculo() {
		
	}
	
	public boolean isAlugado() {
		return alugado;
	}
	public String getMarca() {
		return marca;
	}
	public String getPlaca() {
		return placa;
	}
	public double getValorAluguel() {
		return valorAluguel;
	}
	public int getQuilometragem() {
		return Quilometragem;
	}
	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public void setValorAluguel(double valorAluguel) {
		this.valorAluguel = valorAluguel;
	}
	public void setQuilometragem(int quilometragem) {
		Quilometragem = quilometragem;
	}
	
	
}
