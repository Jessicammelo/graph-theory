package TrabalhoParcial01;

public class TrabalhoParcial01 {

	int matrizA[][] = { { 0, 0, 1 }, { 1, 0, 1 }, { 0, 0, 0 } };
	boolean isNulo = true;
	boolean isMultigrafo = false;
	boolean isSimples = false;
	boolean isCompleto = false;
	boolean isRegular = false;
	boolean isGrafoDirigido = false;
	boolean isGrafoNaoDirigido = false;

	public void tipoDoGrafo() {
		for (int i = 0; i < matrizA.length; i++) {
			for (int j = 0; j < matrizA.length; j++) {
				if (matrizA[i][j] != 0 || matrizA[j][i] != 0) {
					isNulo = false;
				}
				if (matrizA[i][j] == 2 || matrizA[j][i] > 1) {
					isMultigrafo = true;
				} else {
					isSimples = true;
				}
				if (matrizA[i][j] == matrizA[j][i]) {
					isGrafoNaoDirigido = true;
				} else if (matrizA[i][j] != matrizA[j][i]) {
					isGrafoDirigido = true;
				}
				if (matrizA[i][j] == 1 && matrizA[j][i] == 0) {
					isCompleto = true;
				} else {
					isCompleto = false;
				}
				if ((matrizA[i][j] == 1 && matrizA[j][i] == 0) && (matrizA[j][i] == 0 && matrizA[i][j] == 1)) {
					isRegular = true;
				} else {
					isRegular = false;
				}
			}
		}
		System.out.print("a. Qual é o tipo do grafo?\n");
		if (isGrafoDirigido) {
			System.out.print("Dirigido,");
		} else {
			System.out.print("Não dirigido,");
		}
		if (isMultigrafo) {
			System.out.print(" multigrafo,");
		} else {
			System.out.print(" um grafo simples,");
		}
		if (isCompleto) {
			System.out.print(" completo,");
		} else {
			System.out.print(" não é completo,");
		}
		if (isRegular) {
			System.out.print(" e é regular.");
		} else {
			System.out.print(" e não é regular.\n");
		}

	}

	public void arestasDoGrafo() {
		int quantArestas = 0;
		int quantEntrada = 0;
		int quantSaida = 0;
		int entrada[] = new int[matrizA.length];

		int saida[] = new int[matrizA[0].length];

		if (isGrafoDirigido) {

			for (int i = 0; i < matrizA.length; i++) {
				int linha[] = matrizA[i];
				int totalLinha = 0;
				for (int j = 0; j < linha.length; j++) {
					totalLinha += linha[j];
				}
				saida[i] = totalLinha;
			}
			System.out.print("b. Quantas arestas esse grafo possui?\n");
			System.out.print("Conjunto de arestas saída: ");
			for (int i = 0; i < saida.length; i++) {
				quantSaida += saida[i];
				System.out.print(saida[i] + ", ");
			}

			for (int j = 0; j < matrizA[0].length; j++) {
				int totalColuna = 0;
				for (int i = 0; i < matrizA.length; i++) {
					totalColuna += matrizA[i][j];
				}
				entrada[j] = totalColuna;
			}
			System.out.println("");
			System.out.print("Conjunto de arestas entrada: ");
			for (int i = 0; i < entrada.length; i++) {
				quantEntrada += entrada[i];
				System.out.print(entrada[i] + ", ");
			}
			System.out.println("");
			quantArestas = (quantEntrada + quantSaida) /2;
			System.out.println("Quantidade de arestas do grafo: " + quantArestas);
			
		} else if (isGrafoNaoDirigido) {
			for (int i = 0; i < matrizA.length; i++) {
				int linha[] = matrizA[i];
				int totalLinha = 0;
				for (int j = 0; j < linha.length; j++) {
					totalLinha += linha[j];
				}
				saida[i] = totalLinha;
			}
			System.out.print("b. Quantas arestas esse grafo possui?\n");
			System.out.print("Conjunto de arestas saída: ");
			for (int i = 0; i < saida.length; i++) {
				quantSaida += saida[i];
				System.out.print(saida[i] + ", ");
			}
			System.out.println("");
			quantArestas = (quantSaida /2);
			System.out.println("Quantidade de arestas do grafo: " + quantArestas);
		}
	}
}
