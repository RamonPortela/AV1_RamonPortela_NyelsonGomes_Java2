package com.loja;

import java.util.ArrayList;
import java.util.Scanner;

import com.montadora.Carro;
import com.montadora.Motocicleta;
import com.montadora.Veiculo;
import com.utilitarios.Impressora;

public class Loja {
	
	private static final int VEICULO_NAO_ENCONTRADO = -1;
	
	private String endereco;
	private String nome;
	private ArrayList<Veiculo> estoqueDeVeiculos = new ArrayList<Veiculo>();
	
	public ArrayList<Veiculo> getEstoqueDeVeiculos() {
		return estoqueDeVeiculos;
	}

	public void setEstoqueDeVeiculos(ArrayList<Veiculo> estoqueDeVeiculos) {
		this.estoqueDeVeiculos = estoqueDeVeiculos;
	}

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
			System.out.println("Digite 1 para adicionar um carro.");
			System.out.println("Digite 2 para adicionar uma motocicleta.");
			System.out.print("Entre com a op��o desejada: ");
			
			opcaoDeVeiculo = input.nextInt();
			System.out.println("");
			
			if((opcaoDeVeiculo < 1) || (opcaoDeVeiculo > 2)){
				System.out.println("Op��o inv�lida. Entre com a op��o novamente.");
			}
			
		}while((opcaoDeVeiculo < 1) || (opcaoDeVeiculo > 2));
		
		switch(opcaoDeVeiculo){
			case 1:
					Veiculo carro = new Carro();
					carro = carro.criarVeiculo(input);//chama m�todo de criar carro
					this.estoqueDeVeiculos.add(carro);//adiciona carro na lista
				break;
			case 2:
					Veiculo moto = new Motocicleta();
					moto = moto.criarVeiculo(input);//chama m�todo de criar moto
					this.estoqueDeVeiculos.add(moto);//adiciona carro na moto
				break;
		}
		System.out.println("Ve�culo adicionado ao estoque com sucesso.");
	}
	
	public void excluirVeiculo(Scanner input){
	 	
		int posicaoLista = procurarVeiculo(input);//chama o m�todo procuraVeiculo(ele retorna a posi��o do veiculo na lista)
		
		if(posicaoLista != VEICULO_NAO_ENCONTRADO){
			this.estoqueDeVeiculos.remove(posicaoLista);//remove o veiculo que est� na posi��o retornada pelo m�todo
			System.out.println("Veiculo removido do estoque com sucesso.");
		}
		else{
			System.out.println("Veiculo n�o encontrado no estoque");
		}
	}	
	
	public void listarVeiculos(){
		if(this.estoqueDeVeiculos.isEmpty()){
			System.out.println("Estoque est� vazio.");
		}else{
			for(Veiculo veiculo : this.estoqueDeVeiculos){//for-each que percorre a lista de veiculos
				if(veiculo instanceof Carro){//checa se o veiculo � um carro
					Carro carro = (Carro) veiculo;//se o veiculo for um carro, transforma de volta em um objeto carro
					Impressora.imprimeCarro(carro);
				}else{//se for moto
					Motocicleta moto = (Motocicleta) veiculo;//transforma o veiculo de volta em um objeto motocicleta
					Impressora.imprimeMoto(moto);
				}
				System.out.println("");
			}			
		}
	}
	
	public void listarCarros(){//imprime somente o estoque de carros
		
		for(Veiculo veiculo : this.estoqueDeVeiculos){//percorre arraylist
			if(veiculo instanceof Carro){//checa se o veiculo � um carro, se for imprime os dados do carro na tela
				Carro carro = (Carro) veiculo;
				Impressora.imprimeCarro(carro);
				System.out.println("");
			}
		}	
	}
	
	public void buscarVeiculo(Scanner input){
	 	
		int posicaoLista = procurarVeiculo(input);//chama o m�todo procuraVeiculo(ele retorna a posi��o do veiculo na lista)
		
		if(posicaoLista != VEICULO_NAO_ENCONTRADO){
			Veiculo veiculo = this.estoqueDeVeiculos.get(posicaoLista);//recupera o veiculo que est� na posi��o retornada pelo m�todo
			if(veiculo instanceof Carro){
				Carro carro = (Carro) veiculo;
				Impressora.imprimeCarro(carro);
			}
			else{
				Motocicleta moto = (Motocicleta) veiculo;
				Impressora.imprimeMoto(moto);
			}	
		}
		else{
			System.out.println("Veiculo n�o encontrado no estoque");
		}
	}
	
	public void listarMotos(){//imprime somente estoque de motos
		
		for(Veiculo veiculo : this.estoqueDeVeiculos){//percorre arraylist de veiculos
			if(veiculo instanceof Motocicleta){//checa se � moto
				Motocicleta moto = (Motocicleta) veiculo;
				Impressora.imprimeMoto(moto);
				System.out.println("");
			}
		}
	}
	
	private int procurarVeiculo(Scanner input){
		int posicaoLista = 0;
		String chassi;
		Veiculo veiculo;
		
		input.nextLine();
		System.out.println("Entre com o chassi do veiculo: ");
		chassi = input.nextLine();
		
		while(posicaoLista < this.estoqueDeVeiculos.size()){//while que percorre toda a lista e se tem o controle de que posi��o da lista em que ele est�
			veiculo = this.estoqueDeVeiculos.get(posicaoLista);//recupera o veiculo da lista
			if(veiculo.getChassi().equals(chassi)){//checa se o chassi � igual ao indicado pelo usu�rio
				return posicaoLista;//se for igual retorna qual posi��o da lista aquele veiculo est�
			}
			posicaoLista++;
		}
		return VEICULO_NAO_ENCONTRADO;
	}	
}
