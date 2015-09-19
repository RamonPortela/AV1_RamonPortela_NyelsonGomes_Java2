package com.utilitarios;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;

import com.loja.Loja;
import com.montadora.Veiculo;

public class SalvaEstoque {

	private Formatter output; // Objeto utilizado para gerar o arquivo de texto

	// Cria ou abre um arquivo
	public boolean abrirArquivo() {
		try {
			output = new Formatter("Estoque.txt");
		} catch (FileNotFoundException falhaAbertura) {
			System.err.println("Erro na criação ou Abertura do Arquivo");
			return false;
		}
		return true;
	}

	public void gravarEstoque(Loja loja) {
		ArrayList<Veiculo> estoqueDeVeiculos = loja.getEstoqueDeVeiculos();

		for (Veiculo veiculo : estoqueDeVeiculos) {

			switch (veiculo.getTipoVeiculo()) {
				case 1:

					output.format("+============-CARRO-===============+%n"
							+ "| Chassi:%-25s |" + "%n| Montadora:%-22s |"
							+ "%n| Tipo:%-27s |" + "%n| Modelo:%-25s |"
							+ "%n| Motorização:%-20s |" + "%n| Câmbio:%-25s |"
							+ "%n| Cor:%-28s |" + "%n| Preço:%-26s |"
							+ "%n+==================================+",
							veiculo.getEspecificacaoVeiculo().getChassi(), veiculo.getEspecificacaoVeiculo().getMontadora(),
							veiculo.getEspecificacaoVeiculo().getTipo(), veiculo.getEspecificacaoVeiculo().getModelo(),
							veiculo.getEspecificacaoVeiculo().getMotorizacao(), veiculo.getEspecificacaoVeiculo().getCambio(),
							veiculo.getEspecificacaoVeiculo().getCor(), veiculo.getEspecificacaoVeiculo().getPreco());
				break;

				case 2:
					output.format("+============-MOTO-================+%n"
							+ "| Chassi:%-25s |" + "%n| Montadora:%-22s |"
							+ "%n| Tipo:%-27s |" + "%n| Modelo:%-25s |"
							+ "%n| Cilindrada:%-21s |"
							+ "%n| Capacidade do Tanque:%-4s litros |"
							+ "%n| Cor:%-28s |" + "%n| Preço:%-26s |"
							+ "%n+==================================+",
							veiculo.getEspecificacaoVeiculo().getChassi(), veiculo.getEspecificacaoVeiculo().getMontadora(), veiculo.getEspecificacaoVeiculo().getTipo(),
							veiculo.getEspecificacaoVeiculo().getModelo(), veiculo.getEspecificacaoVeiculo().getCilindrada(),
							veiculo.getEspecificacaoVeiculo().getCapacidadeDoTanque(), veiculo.getEspecificacaoVeiculo().getCor(),
							veiculo.getEspecificacaoVeiculo().getPreco());
				break;

			}

			output.format("%n");
		}

	}

	public void fecharArquivo() {
		if (output != null) {
			output.close();
		}
	}
}
