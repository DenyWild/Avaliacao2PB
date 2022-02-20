package questao9;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProdutoDAO implements MetodosDAO {

	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;

	}

	public void inserirOferta(Produto produto) {
		String sql = " INSERT INTO produto (nome, descricao, desconto, data_inicio) VALUES ( ?, ?, ?, ? ) ";

		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			pstm.setFloat(3, produto.getDesconto());
			pstm.setDate(4, Date.valueOf(LocalDate.now()));

			pstm.execute();

			List<String> produtos3 = produtosASeremInseridos();

			for (int i = 0; i <= 2; i++) {

				Collections.shuffle(produtos3);
				String sql2 = "INSERT INTO produto ( nome, descricao, desconto, data_inicio) VALUES ("
						+ produtos3.get(0) + ")";
				PreparedStatement pstm1 = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
				pstm1.execute();
			}
			try (ResultSet rst = pstm.getGeneratedKeys()) {

				while (rst.next()) {
					Integer id = rst.getInt(1);
					System.out.println("O id criado foi o: " + id);
				}
			}

		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	public List<Produto> listarOfertas() {
		List<Produto> ofertas = new ArrayList<Produto>();
		String sql = " SELECT id, nome, descricao, desconto, data_inicio FROM produto ";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {

			try (ResultSet rst = pstm.executeQuery()) {

				while (rst.next()) {
					Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getFloat(4),
							rst.getDate(5));

					ofertas.add(produto);

				}

			}

		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
		return ofertas;

	}

	public List<Produto> buscaOfertaPorPalavra(String nome) {

		List<Produto> Ofertas = new ArrayList<Produto>();

		String sql = " SELECT id, nome, descricao, desconto, data_inicio FROM produto WHERE nome LIKE ? ";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {

			pstm.setString(1, "%" + nome + "%");

			try (ResultSet rst = pstm.executeQuery()) {

				while (rst.next()) {
					Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getFloat(4),
							rst.getDate(5));

					Ofertas.add(produto);

				}

			}

		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}

		return Ofertas;

	}

	public void alterarOferta(Produto produto) {

		String sql = " UPDATE produto SET nome = ?, descricao = ? , desconto = ?, data_inicio = ?  WHERE id = ? ";

		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			pstm.setFloat(3, produto.getDesconto());
			pstm.setDate(4, Date.valueOf(LocalDate.now()));
			pstm.setInt(5, produto.getId());

			pstm.execute();
			try (ResultSet rst = pstm.getGeneratedKeys()) {

				while (rst.next()) {
					rst.getInt(1);
					System.out.println("id alterado com sucesso");
				}
			}

		} catch (SQLException e) {

		}

	}

	public void excluirOfertaPorId(Integer id) throws SQLException {
		String sql = "DELETE FROM produto WHERE id = ?";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, id);
			pstm.execute();

		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	public boolean validaId(Integer id) throws SQLException {
		String sql = " SELECT id FROM produto WHERE id = ? ";

		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstm.setInt(1, id);

			pstm.execute();

			ResultSet rst = pstm.executeQuery();
			return rst.next();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<String> produtosASeremInseridos() {

		String sql1 = " 'notebook', 'notebook com intel i3 7th gen', 430.00, '20200217'";
		String sql2 = " 'geladeira', 'ultima geração de geladeira inteligente', 430.00, '20190825'";
		String sql3 = " 'celular', 'celular moto g50', 430.00, '20200405'";
		String sql4 = " 'microondas', 'frita como ninguém', 430.00, '20220131'";
		String sql5 = " 'aspirador de pó', 'vamo tirar essa sujeira com o seu novo aspirador limpa rapido', 430.00, '20210304'";
		String sql6 = " 'cadeira gamer', 'confortavel e com ajuste para as costas', 430.00, '20210917'";

		List<String> produtos3 = new ArrayList();

		produtos3.add(sql1);
		produtos3.add(sql2);
		produtos3.add(sql3);
		produtos3.add(sql4);
		produtos3.add(sql5);
		produtos3.add(sql6);

		return produtos3;
	}

}
