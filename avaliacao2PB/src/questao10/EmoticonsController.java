package questao10;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EmoticonsController {

	Scanner entrada = new Scanner(System.in);

	private EmoticonsDAO emoticonsDAO;

	public EmoticonsController() throws SQLException {
		Connection connection = new ConnectionFactory().recuperaConexao();
		this.emoticonsDAO = new EmoticonsDAO(connection);
	}

	public void entradaDeFrase() throws ErroAoUtilizarMetodo {
		System.out.println("Descreva o que você está sentindo com :-) ou :-( em uma frase:");
		String frase = entrada.nextLine();

		determinaSentimento(frase);
	}

	public void determinaSentimento(String frase) throws ErroAoUtilizarMetodo {
		int divertido = 0;
		int chateado = 0;

		String caraDivertida = ":-)";
		String caraChateada = ":-(";

		try {

			if (frase.indexOf(caraDivertida) > -1) {

				divertido++;
			}
			if (frase.indexOf(caraChateada) > -1) {

				chateado++;
			}
			if (frase.lastIndexOf(caraChateada) > frase.indexOf(caraChateada)) {

				chateado++;
			}
			if (frase.lastIndexOf(caraDivertida) > frase.indexOf(caraDivertida)) {

				divertido++;
			}
			if (frase.lastIndexOf(caraChateada, frase.lastIndexOf(caraChateada)) > frase.lastIndexOf(caraChateada)) {
				chateado++;
			}
			if (frase.lastIndexOf(caraDivertida, frase.lastIndexOf(caraDivertida)) > frase.lastIndexOf(caraDivertida)) {
				divertido++;
			}

		} catch (CaractereEspecialNaoReconhecidoPelaString c) {
			System.out.println();
		}

		try {
			validandoInsercao(divertido, chateado);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void validandoInsercao(int divertido, int chateado) throws SQLException {
		String sentimento = null;

		if (divertido > chateado) {
			sentimento = "divertido";
		}
		if (divertido < chateado) {
			sentimento = "chateado";
		} else if (divertido == chateado) {
			sentimento = "neutro";
		}

		sentimentoEmoticon(sentimento);

	}

	public void sentimentoEmoticon(String sentimento) throws SQLException {
		System.out.println(sentimento);
		this.emoticonsDAO.sentimentoEmoticon(sentimento);
	}

}
