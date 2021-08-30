package grafos;

public class RepresentacaoGrafos {
	int matrizA[][] = { { 0, 1, 1, 0, 0 }, { 1, 0, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 0, 1, 0, 0 }, { 0, 1, 0, 0, 0 } };
	boolean tipoGrafo = true;

	public void test() {
		for (int i = 0; i < matrizA.length; i++) {
			for (int j = 0; j < matrizA.length; j++) {
				if (matrizA[i][j] != matrizA[j][i]) {
					tipoGrafo = false;
				}
			}
		}
		if (tipoGrafo) {
			System.out.println("Não dirigido");
		} else {
			System.out.println("Dirigido");
		}
	}
}
