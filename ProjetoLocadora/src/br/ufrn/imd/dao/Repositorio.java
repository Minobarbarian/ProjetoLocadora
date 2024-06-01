package br.ufrn.imd.dao;

//import java.util.ArrayList;
import java.util.Scanner;

import br.ufrn.imd.modelo.*;
import br.ufrn.imd.dao.*;

public class Repositorio {
	private Scanner scanner;

    public Repositorio() {
        this.scanner = new Scanner(System.in);
    }
    
    public void acao(int op1, int op2) {
    	switch(op1) {
    		case 1: 
    			criar(op2);
    			break;
    		case 2: 
    			ler(op2);
    			break;
    		case 3: 
    			escrever(op2);
    			break;
    		case 4: 
    			apagar(op2);
    			break;
    		default: System.out.println("Opção CRUD inválida!");
		}
    }
    
	public void criar(int opcao) {
		switch(opcao) {
		case 1: 
			System.out.println("Criando Veiculo...");
			Veiculo v = new Veiculo();
			
			System.out.print("Insira a quilometragem: ");
			v.setQuilometragem(scanner.nextInt());
			
			System.out.print("Insira o valor do aluguel: ");
			v.setValorAluguel(scanner.nextDouble());
			
			scanner.nextLine();
			System.out.print("Insira a marca: ");
			v.setMarca(scanner.nextLine());
			
			System.out.print("Insira a placa: ");
			v.setPlaca(scanner.nextLine());
			
			System.out.print("Insira se é alugado (1) ou não (0): ");
			v.setAlugado(scanner.nextInt());
			
			VeiculoDAO vDAO = new VeiculoDAO();
			vDAO.criarVeiculo(v);
			break;
		case 2: 
			System.out.println("Criando Carro...");
			Carro c = new Carro();
			
			System.out.print("Insira o id do veiculo vinculado: ");
			c.setId_veiculo(scanner.nextInt());
			
			System.out.print("Insira a quantidade de portas: ");
			c.setPortas(scanner.nextInt());
			
			System.out.print("Insira o valor da potencia do carro: ");
			c.setPotencia(scanner.nextInt());
			
			CarroDAO cDAO = new CarroDAO();
			cDAO.criarCarro(c);
			break;
		case 3: 
			System.out.println("Criando Moto...");
			Moto m = new Moto();
			
			System.out.print("Insira o id do veiculo vinculado: ");
			m.setId_veiculo(scanner.nextInt());
			
			System.out.print("Insira o número de cilindradas: ");
			m.setCilindradas(scanner.nextInt());
			
			scanner.nextLine();
			System.out.print("Insira o tipo de partida: ");
			m.setPartida(scanner.nextLine());
			
			MotoDAO mDAO = new MotoDAO();
			mDAO.criarMoto(m);
			break;
		case 4: 
			System.out.println("Criando Endereço...");
			Endereco e = new Endereco();
			
			System.out.print("Insira a rua: ");
			e.setRua(scanner.nextLine());
			
			System.out.print("Insira o cep: ");
			e.setCep(scanner.nextLine());
			
			System.out.print("Insira a cidade: ");
			e.setCidade(scanner.nextLine());
			
			System.out.print("Insira o estado: ");
			e.setEstado(scanner.nextLine());
			
			EnderecoDAO eDAO = new EnderecoDAO();
			eDAO.criarEndereco(e);
			break;
		case 5: 
			System.out.println("Criando Usuario...");
			Usuario u = new Usuario();
			
			System.out.print("Insira o id do endereço vinculado: ");
			u.setId_endereco(scanner.nextInt());
			
			scanner.nextLine();
			System.out.print("Insira o nome: ");
			u.setNome(scanner.nextLine());
			
			System.out.print("Insira o login: ");
			u.setLogin(scanner.nextLine());
			
			System.out.print("Insira a senha: ");
			u.setSenha(scanner.nextLine());
			
			System.out.print("Insira o email: ");
			u.setEmail(scanner.nextLine());
			
			System.out.print("Insira o telefone: ");
			u.setTelefone(scanner.nextLine());
			
			System.out.print("Insira a data de nascimento (yyyy-MM-dd): ");
			u.setDataNascimento(scanner.nextLine());
			
			UsuarioDAO uDAO = new UsuarioDAO();
			uDAO.criarUsuario(u);
			break;
		case 6: 
			System.out.println("Criando Admin...");
			Admin a = new Admin();
			
			System.out.print("Insira o id do usuario vinculado: ");
			a.setId_usuario(scanner.nextInt());
			
			scanner.nextLine();
			System.out.print("Insira o nome do cargo: ");
			a.setCargo(scanner.nextLine());
			
			System.out.print("Insira o nome do supervisor: ");
			a.setSupervisor(scanner.nextLine());
			
			System.out.print("Insira o nome do departamento: ");
			a.setDepartamento(scanner.nextLine());
			
			AdminDAO aDAO = new AdminDAO();
			aDAO.criarAdmin(a);
			break;
		default:
			System.out.println("Opção de Criar inválida!");
		}
	}
	
	public void ler(int opcao) {
		String marca, placa, cep, estado, login, senha;
		switch(opcao) {
		case 1:
			System.out.println("Lendo Veiculo...");			
			
			System.out.print("Insira o nome da marca para busca: ");
			marca = scanner.nextLine();
			
			System.out.print("Insira o nome da placa para busca: ");
			placa = scanner.nextLine();
			
			VeiculoDAO vDAO = new VeiculoDAO();
			Veiculo v = vDAO.pegarVeiculo(marca, placa);
			System.out.println("Coletado: "+v.getId_veiculo()+" "+v.getQuilometragem()+" "+v.getAlugado()+" "+v.getMarca()+" "+v.getPlaca()+" "+v.getValorAluguel());
			break;
		case 2:
			System.out.println("Lendo Carro...");			
			
			System.out.print("Insira o nome da marca para busca: ");
			marca = scanner.nextLine();
			
			System.out.print("Insira o nome da placa para busca: ");
			placa = scanner.nextLine();
			
			CarroDAO cDAO = new CarroDAO();
			Carro c = cDAO.pegarCarro(marca, placa);
			System.out.println("Coletado: "+c.getId_carro()+" "+c.getId_veiculo()+" "+c.getPortas()+" "+c.getPotencia());
			break;
		case 3:
			System.out.println("Lendo Moto...");			
			
			System.out.print("Insira o nome da marca para busca: ");
			marca = scanner.nextLine();
			
			System.out.print("Insira o nome da placa para busca: ");
			placa = scanner.nextLine();
			
			MotoDAO mDAO = new MotoDAO();
			Moto m = mDAO.pegarMoto(marca, placa);
			System.out.println("Coletado: "+m.getId_moto()+" "+m.getId_veiculo()+" "+m.getCilindradas()+" "+m.getPartida());
			break;
		case 4:
			System.out.println("Lendo Endereço...");			
			
			System.out.print("Insira o cep: ");
			cep = scanner.nextLine();
			
			System.out.print("Insira o estado: ");
			estado = scanner.nextLine();
			
			EnderecoDAO eDAO = new EnderecoDAO();
			Endereco e = eDAO.pegarEndereco(cep, estado);
			System.out.println("Coletado: "+e.getId_endereco()+" "+e.getRua()+" "+e.getCidade()+" "+e.getEstado()+" "+e.getCep());
			break;
		case 5:
			System.out.println("Lendo Usuário...");			
			
			System.out.print("Insira o login: ");
			login = scanner.nextLine();
			
			System.out.print("Insira a senha: ");
			senha = scanner.nextLine();
			
			UsuarioDAO uDAO = new UsuarioDAO();
			Usuario u = uDAO.pegarUsuario(login, senha);
			System.out.println("Coletado: "+u.getId_usuario()+" "+u.getId_endereco()+" "+u.getNome()+" "+u.getLogin()+" "+u.getSenha()+" "+u.getEmail()+" "+u.getTelefone()+" "+u.getDataNascimento());
			break;
		case 6:
			System.out.println("Lendo Admin...");			
			
			System.out.print("Insira o login: ");
			login = scanner.nextLine();
			
			System.out.print("Insira a senha: ");
			senha = scanner.nextLine();
			
			AdminDAO aDAO = new AdminDAO();
			Admin a = aDAO.pegarAdmin(login, senha);
			System.out.println("Coletado: "+a.getId_admin()+" "+a.getId_usuario()+" "+a.getCargo()+" "+a.getSupervisor()+" "+a.getDepartamento());
			break;
		default: System.out.println("Opção de leitura inválida!");
		}
	}
	
	public void escrever(int opcao) {
		switch(opcao) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		default: System.out.println("Opção de leitura inválida!");
		}
	}
	
	public void apagar(int opcao) {
		switch(opcao) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		default: System.out.println("Opção de leitura inválida!");
		}
	}
	
	
	
	/*private ArrayList<Veiculo> veiculos;
	
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
	}*/
	
}
