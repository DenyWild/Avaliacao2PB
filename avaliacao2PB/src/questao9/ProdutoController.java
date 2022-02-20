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

	public ProdutoController(Connection connection) throws SQLException {
		this.produtoDAO = new ProdutoDAO(connection);
	}

	public void InserirOferta(Produto produto) {

		this.produtoDAO.inserirOferta(produto);

	}

	public void buscaOfertaPorPalavra(String nome) {

		List<Produto> listarBusca = this.produtoDAO.buscaOfertaPorPalavra(nome);

		listarBusca.stream().forEach(contemPalavra -> System.out.println(contemPalavra));

	}

	public void alterarOferta(Produto produto) throws SQLException {

		this.produtoDAO.alterarOferta(produto);
	}

	public void excluiOferta(Integer id) throws SQLException {

		this.produtoDAO.excluirOfertaPorId(id);
	}

	public void listarProdutos() {

		List<Produto> listar = this.produtoDAO.listarOfertas();

		listar.stream().forEach(lista -> System.out.println(lista));

	}
	public boolean validaId(Integer id) throws SQLException {
		boolean retorno =this.produtoDAO.validaId(id);
		
		return retorno;
	}

}
