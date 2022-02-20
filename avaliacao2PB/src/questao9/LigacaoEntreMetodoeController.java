package questao9;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class LigacaoEntreMetodoeController {
	private static final java.sql.Date Date = null;
	Locale localeAmericano = new Locale("en", "US");
	Scanner entrada = new Scanner(System.in);
	Produto produto = new Produto(null, null, null, 0, Date);
	private ProdutoController produtoController;

	public LigacaoEntreMetodoeController() throws SQLException {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.produtoController = new ProdutoController(connection);
	}

	public void inserirOferta(int opcao) {

		try {
			if (opcao > 1) {
				System.out.println("Pressione Enter para iniciar a inserção");
				entrada.nextLine();
			} else if (opcao > 1 || opcao == 1) {
				System.out.println("Insira o nome do produto: ");
				produto.setNome(entrada.nextLine());

				System.out.println("Insira a descrição do produto: ");
				produto.setDescricao(entrada.nextLine());
				System.out.println("Insira o valor do desconto: ");
				float desconto = 0;

				try {
					desconto = entrada.useLocale(localeAmericano).nextFloat();

				} catch (DadoNaoEsperadoParaVariavel i) {

				}
				produto.setDesconto(desconto);
				produto.setData_inicio(Date.valueOf(LocalDate.now()));

				this.produtoController.InserirOferta(produto);

			}
		} catch (InputMismatchException in) {
			in.printStackTrace();
			System.out.println("Dado não esperado para variavel");
		} catch (NullPointerException nul) {
			nul.printStackTrace();
			System.out.println("Variavel Nula");
		}

	}

	public void alterarOferta() throws SQLException {
		int opcao = 2;
		System.out.println("Insira o id que deseja alterar: ");
		produto.setId(entrada.nextInt());
		if (this.produtoController.validaId(produto.getId()) == true) {
			entrada.nextLine();
			System.out.println("Insira o nome do produto: ");
			produto.setNome(entrada.nextLine());
			System.out.println("Insira a descrição do produto: ");
			produto.setDescricao(entrada.nextLine());
			System.out.println("Insira o valor do desconto: ");
			produto.setDesconto(entrada.useLocale(localeAmericano).nextFloat());
			this.produtoController.alterarOferta(produto);
		} else if (this.produtoController.validaId(produto.getId()) == false) {
			System.out.println("Voce precisa inserir o produto com o id inserido para poder alteralo");

			inserirOferta(opcao);
		}
	}

	public void excluirOferta() throws SQLException {
		int opcao = 3;
		System.out.println("Insira o id que você deseja excluir:");
		Integer id = entrada.nextInt();
		if (this.produtoController.validaId(id) == true) {
			this.produtoController.excluiOferta(id);
		} else if (this.produtoController.validaId(id) == false) {
			inserirOferta(opcao);
		}
	}

	public void listarProdutos() {
		this.produtoController.listarProdutos();
	}

	public void buscaOfertaPorPalavra() {
		System.out.println("Insira a palavra que você deseja buscar: ");
		produto.setNome(entrada.nextLine());

		this.produtoController.buscaOfertaPorPalavra(produto);
	}

}
