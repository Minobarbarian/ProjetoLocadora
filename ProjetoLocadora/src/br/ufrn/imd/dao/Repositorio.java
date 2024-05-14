package br.ufrn.imd.dao;

import java.util.ArrayList;
import br.ufrn.imd.modelo.*;

public class Repositorio {
	private ArrayList<Veiculo> veiculos;
	
	public Repositorio() {
		veiculos = new ArrayList<Veiculo>();
	}
	
	public void addVeiculo(Veiculo v) {
		veiculos.add(v);
	}
	
	public void listar_veiculos_e_marca_popular() {
		System.out.println("Lista de Veiculos:");
		String marca_popular = "Nenhuma";
		for(Veiculo v : veiculos) {
			if(v instanceof Carro) {
				marca_popular = v.getMarca();
			}
			System.out.println("Veiculo: " + v.getClass() + "\t" + "Marca: " + v.getMarca() + "\t" + "Placa: " + v.getPlaca());
		}
		System.out.println();
		System.out.println("Marca com maior numero de carros: ");
		System.out.println(marca_popular);
	}
	
	public void listar_veiculos_alugados() {
		System.out.println("==============Alugados==============");
		double valor_total = 0;
		for(Veiculo v : veiculos) {
			if(v.isAlugado()) {
				valor_total += v.getValorAluguel();
				if(v instanceof Carro) {
					System.out.println("Carro: " + v.getMarca() + " Placa: " + v.getPlaca() + " Motor : " + ((Carro)v).getPotencia() + " Portas: " + ((Carro)v).getPortas());
				} else {
					System.out.println("Moto: " + v.getMarca() + " Placa: " + v.getPlaca() + " Partida: " + ((Moto)v).getPartida() + " Cilindradas : " + ((Moto)v).getCilindradas());
				}
			}
		}
		System.out.println("Valor total dos alugueis: " + valor_total);
		System.out.println("==============  Fim   ==============");
	}
	
	public void listar_veiculos_disponiveis() {
		System.out.println("==============Disponiveis==============");
		Veiculo v1 = new Veiculo();
		v1.setValorAluguel(-300);
		for(Veiculo v : veiculos) {
			if(!v.isAlugado()) {
				if(v1.getValorAluguel() < v.getValorAluguel()) {
					v1.setValorAluguel(v.getValorAluguel());
					v1.setPlaca(v.getPlaca());
				}
				if(v instanceof Carro) {
					System.out.println("Carro: " + v.getMarca() + " Placa: " + v.getPlaca() + " Motor : " + ((Carro)v).getPotencia() + " Portas: " + ((Carro)v).getPortas() + " Valor aluguel : " + v.getValorAluguel());
				} else {
					System.out.println("Moto: " + v.getMarca() + " Placa: " + v.getPlaca() + " Partida: " + ((Moto)v).getPartida() + " Valor aluguel : " + v.getValorAluguel());
				}
			}
		}
		System.out.println("Veiculo com maior valor de aluguel: " + v1.getPlaca());
		System.out.println("==============  Fim   ==============");
	}
	
	public void manutencao() {
		System.out.println("==============Manutenção==============");
		int flag;
		double quantidade_total = 0;
		for(Veiculo v : veiculos) {
			flag = 0;
			if(v instanceof Carro) {
				if(v.getQuilometragem()%7000 == 0) {
					quantidade_total += 3.5;
					flag = 1;
				}
			} else {
				if(v.getQuilometragem()%3500 == 0) {
					quantidade_total += 1.5;
					flag = 1;
				}
			}
			if(flag == 1) System.out.println("Veiculo: " + v.getMarca() + " trocou oleo");
		}
		System.out.println("Quantidade total de litros de oleo: " + quantidade_total);
		System.out.println("==============   Fim   ==============");
	}
	
}
