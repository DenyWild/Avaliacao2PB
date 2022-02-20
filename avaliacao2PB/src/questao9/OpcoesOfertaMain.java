package questao9;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class OpcoesOfertaMain {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory conexao = new ConnectionFactory();
		try (Connection connection = conexao.recuperarConexao()) {
			
			MetodoChecaOpcaoValida metodoValidaOpcao = new MetodoChecaOpcaoValida();

			ProdutoController produtoController = new ProdutoController();

			Scanner input = new Scanner(System.in);
			int opcao;

			do {
				do {
				System.out.println("-------SISTEMA DE OFERTAS--------");
				System.out.println("Digite a opção desejada: ");
				System.out.println("1 - para Inserir nova oferta");
				System.out.println("2 - para alterar uma oferta");
				System.out.println("3 - para Excluir uma nova oferta");
				System.out.println("4 - para Listar ofertas contendo palavras: ");
				System.out.println("5 - para Listar todas as ofertas");
				System.out.println("0 - para SAIR");
				System.out.println("Insira a opção:");
				opcao = input.nextInt();
				metodoValidaOpcao.MetodoChecaOpcaoValida(opcao);
				}
				
				while(opcao >5 || opcao < 0);
				switch (opcao) {
				case 1:
					produtoController.InserirOferta();

					break;
				case 2:
					produtoController.alterarOferta();

					break;
				case 3:
					produtoController.excluiOferta();
					break;
				case 4:
					produtoController.buscaOfertaPorPalavra();
					break;
				case 5:
					produtoController.listarProdutos();
					break;
				}

			} while (opcao != 0);
			System.out.println("SISTEMA FECHADO");
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

}
