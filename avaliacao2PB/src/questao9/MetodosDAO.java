package questao9;

import java.sql.SQLException;
import java.util.List;

public interface MetodosDAO {

	public void inserirOferta(Produto produto);

	public List<Produto> listarOfertas();

	public List<Produto> buscaOfertaPorPalavra(String nome);

	public void alterarOferta(Produto produto);

	public void excluirOfertaPorId(Integer id) throws SQLException;

	public boolean validaId(Integer id) throws SQLException;

	public List<String> produtosASeremInseridos();
}
