package questao10;

import java.util.regex.PatternSyntaxException;

public class CaractereEspecialNaoReconhecidoPelaString extends PatternSyntaxException{

	public CaractereEspecialNaoReconhecidoPelaString(String msg, int numero) {
		super(msg, msg, numero);
	}
}
