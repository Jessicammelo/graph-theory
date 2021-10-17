package Trabalho01;

//Jéssica Maria de Melo Kohn-questão 02
public class Labirinto {

	public String labirinto(int[][] matrizA) {
		int passos = 0;
		int linha = matrizA.length - 1;
		int coluna = 0;
		int valorColunaAtual = matrizA[linha][coluna];

		while (valorColunaAtual != -1) {
			int menorValor = Integer.MAX_VALUE;
			int valorAcima = obterValorPosicao(matrizA, linha - 1, coluna);
			int valorAbaixo = obterValorPosicao(matrizA, linha + 1, coluna);
			int valorDireita = obterValorPosicao(matrizA, linha, coluna + 1);
			int valorEsquerda = obterValorPosicao(matrizA, linha, coluna - 1);
			
			if (menorValor > valorAcima && valorAcima != 0) {
				menorValor = valorAcima;
			}
			if (menorValor > valorAbaixo && valorAbaixo != 0) {
				menorValor = valorAbaixo;
			}
			if (menorValor > valorDireita && valorDireita != 0) {
				menorValor = valorDireita;
			}
			if (menorValor > valorEsquerda && valorEsquerda != 0) {
				menorValor = valorEsquerda;
			}
			
			if (valorAcima == menorValor) {
				linha -= 1;
			}
			if (valorAbaixo == menorValor) {
				linha += 1;
			}
			if (valorDireita == menorValor) {
				coluna += 1;
			}
			if (valorEsquerda == menorValor) {
				coluna -= 1;
			}
			
			valorColunaAtual = menorValor;
			
			passos++;
		}
		return "Quantidade de passos: " + passos;
	}

	private int obterValorPosicao(int[][] matrizA, int linha, int coluna) {
		try {
			return matrizA[linha][coluna];
		} catch (Exception e) {
			return 0;
		}
	}

}
