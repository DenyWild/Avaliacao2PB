package questao9;

public class MetodoChecaOpcaoValida {

	public void MetodoChecaOpcaoValida(int opcao) {
		if (opcao > 5 || opcao < 0) {

			System.out.println("Op��o n�o valida. \nInsira um op��o que esteja no menu!");

		} else {
			System.out.println();
		}
	}

}
