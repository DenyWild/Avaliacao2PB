package questao9;

public class MetodoChecaOpcaoValida {

	public void MetodoChecaOpcaoValida(int opcao) {
		if (opcao > 5 || opcao < 0) {

			System.out.println("Opção não valida. \nInsira um opção que esteja no menu!");

		} else {
			System.out.println();
		}
	}

}
