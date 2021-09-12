package TrabParcial01;

public class TrabParcialMain01 {

	public static void main(String[] args) {

		int matrizA[][] = { { 0, 0, 1 }, { 1, 0, 0 }, { 0, 1, 0 } };

		TrabalhoParcial01 parcial = new TrabalhoParcial01();

		System.out.println("a. Qual é o tipo do grafo?\n");
		System.out.println(parcial.tipoDoGrafo(matrizA));
		
		
		System.out.println("b. Quantas arestas esse grafo possui?\n");
		System.out.println(parcial.arestasDoGrafo(matrizA));
		
		
		System.out.println("c. Qual é o grau de cada vértice?\n");
		System.out.println(parcial.grausDoVertice(matrizA));
		
	}

}
