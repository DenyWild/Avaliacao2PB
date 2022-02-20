package questao10;

import java.sql.Connection;
import java.sql.SQLException;

public class EmoticonsMain {

	public static void main(String[] args) throws SQLException {

		EmoticonsController emoticonsController = new EmoticonsController();

		ConnectionFactory conexao = new ConnectionFactory();
		try (Connection connection = conexao.recuperaConexao()) {

			try {
				emoticonsController.entradaDeFrase();
			} catch (CaractereEspecialNaoReconhecidoPelaString | ErroAoUtilizarMetodo cn) {
				System.out.println("Caracter Especial não é aceito pela String");
				cn.printStackTrace();
			}

		}

	}

}
