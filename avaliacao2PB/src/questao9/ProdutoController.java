package questao9;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProdutoController {

	private ProdutoDAO produtoDAO;

	private static final java.sql.Date Date = null;
	Locale localeAmericano = new Locale("en", "US");
	Scanner entrada = new Scanner(System.in);
	Produto produto = new Produto(null, null, null, 0, Date);

	public ProdutoController() throws SQLException {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.produtoDAO = new ProdutoDAO(connection);
	}

	public void InserirOferta() {

		try {
			System.out.println("Insira o nome do produto: ");
			produto.setNome(entrada.nextLine());
//			entrada.nextLine();
			System.out.println("Insira a descrição do produto: ");
			produto.setDescricao(entrada.nextLine());
			System.out.println("Insira o valor do desconto: ");
			produto.setDesconto(entrada.useLocale(localeAmericano).nextDouble());

			produto.setData_inicio(Date.valueOf(LocalDate.now()));

			this.produtoDAO.inserirOrferta(produto);
		} catch (InputMismatchException in) {
			in.printStackTrace();
			System.out.println("Dado não esperado para variavel");
		} catch (NullPointerException nul) {
			nul.printStackTrace();
			System.out.println("Variavel Nula");
		}

	}

	public void buscaOfertaPorPalavra() {
		System.out.println("Insira a palavra que você deseja buscar: ");
		produto.setNome(entrada.nextLine());

		List<Produto> listarBusca = this.produtoDAO.buscaOfertaPorPalavra(produto);

		listarBusca.stream().forEach(contemPalavra -> System.out.println(contemPalavra));

	}

	public void alterarOferta() throws SQLException {

		System.out.println("Insira o id que deseja alterar: ");
		produto.setId(entrada.nextInt());
		if (this.produtoDAO.validaId(produto.getId()) == true) {
			entrada.nextLine();
			System.out.println("Insira o nome do produto: ");
			produto.setNome(entrada.nextLine());
			System.out.println("Insira a descrição do produto: ");
			produto.setDescricao(entrada.nextLine());
			System.out.println("Insira o valor do desconto: ");
			produto.setDesconto(entrada.useLocale(localeAmericano).nextDouble());
			this.produtoDAO.alterarOferta(produto);
		} else if (this.produtoDAO.validaId(produto.getId()) == false) {
			InserirOferta();
		}

	}

	public void excluiOferta() throws SQLException {
		System.out.println("Insira o id que você deseja excluir:");
		Integer id = entrada.nextInt();
		if (this.produtoDAO.validaId(id) == true) {
			this.produtoDAO.excluirOfertaPorId(id);
		} else if (this.produtoDAO.validaId(id) == false) {
			InserirOferta();
		}

	}

	public void listarProdutos() {
		List<Produto> listar = this.produtoDAO.listarOfertas();

		listar.stream().forEach(lista -> System.out.println(lista));

	}

}
