package TrabParcial01;

import java.util.ArrayList;
import java.util.Collections;

public class TrabalhoParcial01 {
	boolean isNulo = true;
	boolean isMultigrafo = false;
	boolean isSimples = false;
	boolean isCompleto = false;
	boolean isRegular = false;
	boolean isGrafoDirigido = false;
	boolean isGrafoNaoDirigido = false;
	int quantArestas = 0;
	int quantEntrada = 0;
	int quantSaida = 0;

	public String tipoDoGrafo(int[][] matrizA) {
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
				if (matrizA[i][j] == 1 && matrizA[j][i] == 1) {
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

		String retorno = "";
		if (isGrafoDirigido) {
			retorno += "Dirigido,";
		} else {
			retorno += "Não dirigido,";
		}
		if (isMultigrafo) {
			retorno += " multigrafo,";
		} else {
			retorno += " um grafo simples,";
		}
		if (isCompleto) {
			retorno += " completo,";
		} else {
			retorno += " não é completo,";
		}
		if (isRegular) {
			retorno += " e é regular.";
		} else {
			retorno += " e não é regular.\n";
		}
		return retorno;
	}

	public String arestasDoGrafo(int[][] matrizA) {
		int entrada[] = new int[matrizA.length];
		int saida[] = new int[matrizA[0].length];
		String saidaStr = "";
		String entradaStr = "";
		if (isGrafoDirigido) {
			for (int i = 0; i < matrizA.length; i++) {
				int linha[] = matrizA[i];
				int totalLinha = 0;
				for (int j = 0; j < linha.length; j++) {
					totalLinha += linha[j];
				}
				saida[i] = totalLinha;
			}
			for (int i = 0; i < saida.length; i++) {
				quantSaida += saida[i];
				saidaStr += saida[i] + ", ";
			}

			for (int j = 0; j < matrizA[0].length; j++) {
				int totalColuna = 0;
				for (int i = 0; i < matrizA.length; i++) {
					totalColuna += matrizA[i][j];
				}
				entrada[j] = totalColuna;
			}
			for (int i = 0; i < entrada.length; i++) {
				quantEntrada += entrada[i];
				entradaStr += entrada[i] + ", ";
			}
			quantArestas = (quantEntrada + quantSaida) / 2;

			return "Lista do conjunto de arestas:" + "\n" + "Saída: "+ saidaStr + "\n" + "Entrada: "+ entradaStr + "\n" + "Quantidade de arestas do grafo: " + quantArestas + "\n";
		} else if (!isGrafoDirigido) {
			for (int i = 0; i < matrizA.length; i++) {
				int linha[] = matrizA[i];
				int totalLinha = 0;
				for (int j = 0; j < linha.length; j++) {
					totalLinha += linha[j];
				}
				saida[i] = totalLinha;
			}

			for (int i = 0; i < saida.length; i++) {
				quantSaida += saida[i];
				saidaStr += saida[i] + ", ";
			}
			quantArestas = (quantSaida / 2);
			return "Lista do conjunto de arestas: " + saidaStr + "\n" + "Quantidade de arestas do grafo: "
					+ quantArestas + "\n";
		}

		return "";
	}

	public String grausDoVertice(int[][] matrizA) {
		String retornoResposta = "";
		String total = "";
		if (!isGrafoDirigido) {
			ArrayList<Integer> nDireigido = new ArrayList<>();
			for (int i = 0; i < matrizA.length; i++) {
				int linha[] = matrizA[i];
				int totalLinha = 0;
				for (int j = 0; j < linha.length; j++) {
					totalLinha += linha[j];
				}
				nDireigido.add(totalLinha);
				total += "V" + (i + 1) + ": " + totalLinha + ", ";
			}
			Collections.sort(nDireigido, Collections.reverseOrder());
			
			for(int i = 0; i < nDireigido.size(); i++) {
				retornoResposta += nDireigido.get(i) +  ",";
			}
			return "Grau de cada vértice: " + total + "\n" + "Seguência de graus: " + retornoResposta;
		} else if (isGrafoDirigido) {
			for (int i = 0; i < matrizA.length; i++) {
				int saida = 0;
				for(int j = 0; j < matrizA[i].length; j++) {
					saida += matrizA[i][j];
				}
				total += "V " + (i + 1) + ": " + saida + ", ";
			}
			for (int j = 0; j < matrizA[0].length; j++) {
				int totalColuna = 0;
				for (int i = 0; i < matrizA.length; i++) {
					totalColuna += matrizA[i][j];
				}
				retornoResposta += "V " + (j + 1) + ": " + totalColuna + ", ";
			}
			return "Grau de cada vértice: \nSaída: " + total + "\n" + "Entrada: " + retornoResposta;
		}

		return "";
	}
	
}
