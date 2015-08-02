package com.operacional;

import com.montadora.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Loja {
	
	private String endereco;
	private String nome;
	ArrayList<Veiculo> estoqueDeVeiculos = new ArrayList<Veiculo>();
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void adicionarVeiculo(Scanner input) {
		
		int opcaoDeVeiculo;
		
		do{//do while pra ficar pedindo pro usuario digitar novamente caso ele n�o entre com 1 ou 2
			System.out.println("Entre com 1 para adicionar um carro.");
			System.out.println("Entre com 2 para adicionar uma motocicleta.");
			
			opcaoDeVeiculo = input.nextInt();
			if((opcaoDeVeiculo < 1) || (opcaoDeVeiculo > 2)){
				System.out.println("Op��o inv�lida. Entre com a op��o novamente.");
			}
			
		}while((opcaoDeVeiculo < 1) || (opcaoDeVeiculo > 2));
		
		switch(opcaoDeVeiculo){
			case 1:
					Carro carro = new Carro();
					carro = carro.criarVeiculo(input);//chama m�todo de criar carro
					this.estoqueDeVeiculos.add(carro);//adiciona carro na lista
				break;
			case 2:
					Motocicleta moto = new Motocicleta();
					moto = moto.criarVeiculo(input);//chama m�todo de criar moto
					this.estoqueDeVeiculos.add(moto);//adiciona carro na moto
				break;
		}		
	}
	
	public void listarVeiculos(){
		for(Veiculo veiculo : this.estoqueDeVeiculos){//for-each que percorre a lista de veiculos
			if(veiculo instanceof Carro){//checa se o veiculo � um carro
				Carro carro = (Carro) veiculo;//se o veiculo for um carro, transforma de volta em um objeto carro
				System.out.println("-------CARRO-------");
				System.out.println("chassi: "+carro.getChassi());
				System.out.println("Montadora: "+carro.getMontadora());
				System.out.println("Tipo: "+carro.getTipo());
				System.out.println("Modelo: "+carro.getModelo());
				System.out.println("Cor: "+carro.getCor());
				System.out.println("motorizacao: "+carro.getMotorizacao());
				System.out.println("Cambio: "+carro.getCambio());
				System.out.println("Pre�o: "+carro.getPreco());
			}else{//se for moto
				Motocicleta moto = (Motocicleta) veiculo;//transforma o veiculo de volta em um objeto motocicleta
				System.out.println("-------MOTO-------");
				System.out.println("chassi: "+moto.getChassi());
				System.out.println("Montadora: "+moto.getMontadora());
				System.out.println("Tipo: "+moto.getTipo());
				System.out.println("Modelo: "+moto.getModelo());
				System.out.println("Cor: "+moto.getCor());
				System.out.println("Cilindradas: "+moto.getCilindrada());
				System.out.println("Capacidade do tanque: "+moto.getCapacidadeDoTanque()+" Litros");
				System.out.println("Pre�o: "+moto.getPreco());
			}
			System.out.println("");
		}
	}
	
	public void listarCarros(){//imprime somente o estoque de carros
		
		for(Veiculo veiculo : this.estoqueDeVeiculos){//percorre arraylist
			if(veiculo instanceof Carro){//checa se o veiculo � um carro, se for imprime os dados do carro na tela
				Carro carro = (Carro) veiculo;
				System.out.println("-------CARRO-------");
				System.out.println("chassi: "+carro.getChassi());
				System.out.println("Montadora: "+carro.getMontadora());
				System.out.println("Tipo: "+carro.getTipo());
				System.out.println("Modelo: "+carro.getModelo());
				System.out.println("Cor: "+carro.getCor());
				System.out.println("motorizacao: "+carro.getMotorizacao());
				System.out.println("Cambio: "+carro.getCambio());
				System.out.println("Pre�o: "+carro.getPreco());
				System.out.println("");
			}
		}	
	}
	
	/*public void buscarCarro(String chassi){
		boolean achouCarro = false;
		int posicaoLista = 0;
		Carro carro = new Carro();
		
		while(posicaoLista < this.estoqueDeCarros.size()){
			carro = this.estoqueDeCarros.get(posicaoLista);
			if(carro.getChassi() == chassi){
				System.out.println("Chassi: "+carro.getChassi());
				//System.out.println("Montadora: "+carro.getMontadora());
				System.out.println("Tipo: "+carro.getTipo());
				System.out.println("Modelo: "+carro.getModelo());
				System.out.println("Cor: "+carro.getCor());
				System.out.println("Motorizacao: "+carro.getMotorizacao());
				System.out.println("Cambio: "+carro.getCambio());
				System.out.println("Pre�o: "+carro.getPreco());
				achouCarro = true;
				break;
			}
			posicaoLista++;
		}
		if(!achouCarro){
			System.out.println("Carro n�o encontrado.");
		}
	}*/
	
	public void listarMotos(){//imprime somente estoque de motos
		
		for(Veiculo veiculo : this.estoqueDeVeiculos){//percorre arraylist de veiculos
			if(veiculo instanceof Motocicleta){//checa se � moto
				Motocicleta moto = (Motocicleta) veiculo;
				System.out.println("-------MOTO-------");
				System.out.println("chassi: "+moto.getChassi());
				System.out.println("Montadora: "+moto.getMontadora());
				System.out.println("Tipo: "+moto.getTipo());
				System.out.println("Modelo: "+moto.getModelo());
				System.out.println("Cor: "+moto.getCor());
				System.out.println("Cilindradas: "+moto.getCilindrada());
				System.out.println("Capacidade do tanque: "+moto.getCapacidadeDoTanque()+" Litros");
				System.out.println("Pre�o: "+moto.getPreco());	
				System.out.println("");
			}
		}
	}
	
	/*public void buscarMotocicleta(String chassi){
		boolean achouMoto = false;
		int posicaoLista = 0;
		Motocicleta motocicleta = new Motocicleta();
		
		while(posicaoLista < this.estoqueDeMotocicletas.size()){
			motocicleta = this.estoqueDeMotocicletas.get(posicaoLista);
			if(motocicleta.getChassi() == chassi){
				System.out.println("Chassi: " + motocicleta.getChassi());
				System.out.println("Modelo: " + motocicleta.getModelo());
				System.out.println("Tipo: " + motocicleta.getTipo());
				System.out.println("Cor: " + motocicleta.getCor());
				System.out.println("Cilindrada: " + motocicleta.getCilindrada());
				System.out.println("Capacidade do Tanque: " + motocicleta.getCapacidade_do_tanque());
				System.out.println("Pre�o: " + motocicleta.getPreco());
				achouMoto = true;
				break;
			}
			posicaoLista++;
		}
		if(!achouMoto){
			System.out.println("Moto n�o encontrada.");
		}
	}*/
}
