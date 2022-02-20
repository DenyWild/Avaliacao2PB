package questao9;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MetodoOpcoes {

	public void MetodoOpcoes() {
		ConnectionFactory conexao = new ConnectionFactory();
		try (Connection connection = conexao.recuperarConexao()) {

			MetodoChecaOpcaoValida metodoValidaOpcao = new MetodoChecaOpcaoValida();

			LigacaoEntreMetodoeController ligacaoEntreMetodoeController = new LigacaoEntreMetodoeController();

			Scanner input = new Scanner(System.in);
			int opcao;

			do {
				do {
					System.out.println("X-------SISTEMA DE OFERTAS--------X");
					System.out.println("1 - para Inserir nova oferta");
					System.out.println("2 - para alterar uma oferta");
					System.out.println("3 - para deletar uma oferta");
					System.out.println("4 - para Listar ofertas que contem a palavra");
					System.out.println("5 - para Listar todas as ofertas");
					System.out.println("0 - para SAIR");
					System.out.println("X---------------------------------X");
					System.out.println("Insira a opção desejada:");

					opcao = input.nextInt();
					metodoValidaOpcao.MetodoChecaOpcaoValida(opcao);
				}

				while (opcao > 5 || opcao < 0);
				switch (opcao) {
				case 1:
					ligacaoEntreMetodoeController.inserirOferta(opcao);

					break;
				case 2:
					ligacaoEntreMetodoeController.alterarOferta();

					break;
				case 3:
					ligacaoEntreMetodoeController.excluirOferta();
					break;
				case 4:
					ligacaoEntreMetodoeController.buscaOfertaContendoPalavra();
					break;
				case 5:
					ligacaoEntreMetodoeController.listarProdutos();
					break;
				}

			} while (opcao != 0);
			System.out.println("SISTEMA FECHADO");
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
}
