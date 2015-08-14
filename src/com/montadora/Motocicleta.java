package com.montadora;

import java.util.ArrayList;
import java.util.Scanner;

import com.utilitarios.LeVeiculos;

public class Motocicleta extends Veiculo {

	private int cilindrada;
	private int capacidadeDoTanque;

	public enum Tipos {// enum de tipos de motos
		SCOOTER(1, "Scooter"), CUSTOM(2, "Custom"), CHOPPER(3, "Chopper"), STREET(4, "Street"), ESPORTIVA(5, "Esportiva");

		private int opcaoTipo;
		private String nomeTipo;

		private Tipos(int opcaoTipo, String nomeTipo) {
			this.opcaoTipo = opcaoTipo;
			this.nomeTipo = nomeTipo;
		}

		public int getOpcaoTipo() {
			return opcaoTipo;
		}

		public String getNomeTipo() {
			return nomeTipo;
		}
		
	};

	public void setTipo(int opcaoTipo) {
		switch (opcaoTipo) {
		case 1:
			this.tipo = Tipos.SCOOTER.getNomeTipo();
			break;
			
		case 2:
			this.tipo = Tipos.CUSTOM.getNomeTipo();
			break;
			
		case 3:
			this.tipo = Tipos.CHOPPER.getNomeTipo();
			break;
			
		case 4:
			this.tipo = Tipos.STREET.getNomeTipo();
			break;
			
		case 5:
			this.tipo = Tipos.ESPORTIVA.getNomeTipo();
			break;
			
		}
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public enum Montadoras {// enum das montadoras de moto
		HARLEY(1, "HARLEY-DAVIDSON"), HONDA(2, "HONDA"), SUZUKI(3, "SUZUKI"), KAWASAKI(4, "KAWASAKI"), SHINERAY(5, "SHINERAY");

		private int opcaoMontadoras;
		private String nomeMontadoras;

		private Montadoras(int opcaoMontadoras, String nomeMontadoras) {
			this.opcaoMontadoras = opcaoMontadoras;
			this.nomeMontadoras = nomeMontadoras;
		}

		public int getOpcaoMontadoras() {
			return opcaoMontadoras;
		}

		public String getNomeMontadoras() {
			return nomeMontadoras;
		}

	};

	public void setMontadora(int opcaoMontadora) {
		switch (opcaoMontadora) {
		case 1:
			this.montadora = Montadoras.HARLEY.getNomeMontadoras();
			break;
			
		case 2:
			this.montadora = Montadoras.HONDA.getNomeMontadoras();
			break;
			
		case 3:
			this.montadora = Montadoras.SUZUKI.getNomeMontadoras();
			break;
			
		case 4:
			this.montadora = Montadoras.KAWASAKI.getNomeMontadoras();
			break;
			
		case 5:
			this.montadora = Montadoras.SHINERAY.getNomeMontadoras();
			break;
			
		}
		
	}

	public void setMontadora(String montadora) {
		this.montadora = montadora;
	}

	public String getMontadora() {
		return montadora;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	public int getCapacidadeDoTanque() {
		return capacidadeDoTanque;
	}

	public void setCapacidadeDoTanque(int capacidadeDoTanque) {
		this.capacidadeDoTanque = capacidadeDoTanque;
	}

	@Override
	public Motocicleta criarVeiculo(Scanner input, ArrayList<Veiculo> estoqueDeVeiculo) {// método que cria moto a partir do que foi informado pelo usuário
		Motocicleta moto = new Motocicleta();
		String texto;
		String opcoes;

		LeVeiculos.leChassi(input, estoqueDeVeiculo, moto);

		texto = "Escolha uma montadora: ";
		opcoes = "1 - HARLEY-DAVIDSON   \t 2 - HONDA \t 3 - SUZUKI \t 4 - KAWASAKI \t 5 - SHINERAY";
		LeVeiculos.leMontadora(input, moto, texto, opcoes);

		texto = "Entre com o tipo do veículo: ";
		opcoes = "1 - Scooter   \t 2 - Custom \t 3 - Roadster \t 4 - Street \t 5 - Esportiva";
		LeVeiculos.leTipo(input, moto, texto, opcoes);

		input.nextLine();

		LeVeiculos.leModelo(input, moto);
		LeVeiculos.leCor(input, moto);
		LeVeiculos.leCilindradas(input, moto);
		LeVeiculos.leCapacidadeDoTanque(input, moto);
		LeVeiculos.lePreco(input, moto);

		return moto;
	}

}
