package br.ufrn.imd.visao;

import java.util.Scanner;

import br.ufrn.imd.dao.Repositorio;

public class LocaLisa {

	public static void main(String[] args) {
		Repositorio rep = new Repositorio();
		Scanner scanner = new Scanner(System.in);
		
		int op1, op2;
		op1 = 0;
		
		while(op1 != -1) {
			System.out.println("=================");
			System.out.print("Insira as ações: ");
			op1 = scanner.nextInt();
			op2 = scanner.nextInt();
			if(op1 != -1) rep.acao(op1, op2);
		}
		
		
		
		//veiculo1 e veiculo2
		//rep.criar(1);
		//rep.criar(1);
		
		//carro1 e moto1
		//rep.criar(2);
		//rep.criar(3);
		
		//end1 e end2
		//rep.criar(4);
		//rep.criar(4);
		
		//user1 e user 2
		//rep.criar(5);
		//rep.criar(5);
		
		//admin1
		//rep.criar(6);
		
		
		/*Carro c = new Carro();
		c.setAlugado(1);
		c.setMarca("Ford");
		c.setPlaca("AAA-8888");
		c.setPortas(4);
		c.setPotencia(1600);
		c.setValorAluguel(5 * 115.5);
		c.setQuilometragem(21000);
		
		Carro c2 = new Carro();
		c2.setAlugado(1);
		c2.setMarca("Fiat");
		c2.setPlaca("ABB-1000");
		c2.setPortas(4);
		c2.setPotencia(1000);
		c2.setValorAluguel(3 * 75.0);
		c2.setQuilometragem(15000);
		
		Carro c3 = new Carro();
		c3.setAlugado(0);
		c3.setMarca("Fiat");
		c3.setPlaca("ABC-5501");
		c3.setPortas(2);
		c3.setPotencia(1200);
		c3.setValorAluguel(1 * 75.0);
		c3.setQuilometragem(14000);
		
		Moto m1 = new Moto();
		m1.setAlugado(0);
		m1.setMarca("Honda");
		m1.setPlaca("BBB-2019");
		m1.setCilindradas(850);
		m1.setPartida("Elétrica");
		m1.setValorAluguel(1 * 55.25);
		m1.setQuilometragem(3500);
		
		Moto m2 = new Moto();
		m2.setAlugado(0);
		m2.setMarca("Yamaha");
		m2.setPlaca("XYZ-2019");
		m2.setCilindradas(250);
		m2.setPartida("Elétrica");
		m2.setValorAluguel(2 * 55.25);
		m2.setQuilometragem(4500);
		
		rep.addVeiculo(c);
		rep.addVeiculo(c2);
		rep.addVeiculo(c3);
		rep.addVeiculo(m1);
		rep.addVeiculo(m2);
		
		rep.listar_veiculos_e_marca_popular();
		rep.listar_veiculos_alugados();
		rep.listar_veiculos_disponiveis();
		rep.manutencao();*/
	}

}
