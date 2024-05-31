package br.ufrn.imd.modelo;

public class Veiculo {
	protected int id_veiculo;
	protected int Quilometragem;
	protected int alugado;
	protected double valorAluguel;
	protected String marca;
	protected String placa;
	
	public Veiculo() {
		
	}

	public int getId_veiculo() {
		return id_veiculo;
	}

	public int getQuilometragem() {
		return Quilometragem;
	}

	public int getAlugado() {
		return alugado;
	}

	public double getValorAluguel() {
		return valorAluguel;
	}

	public String getMarca() {
		return marca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setId_veiculo(int id_veiculo) {
		this.id_veiculo = id_veiculo;
	}

	public void setQuilometragem(int quilometragem) {
		Quilometragem = quilometragem;
	}

	public void setAlugado(int alugado) {
		this.alugado = alugado;
	}

	public void setValorAluguel(double valorAluguel) {
		this.valorAluguel = valorAluguel;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	
}
