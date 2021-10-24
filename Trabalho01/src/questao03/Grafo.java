package questao03;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

//Jéssica Maria de Melo Kohn questão 03
public class Grafo {

	static int vertices = 5;
	private LinkedList<Integer> adj[];

	public String bfs(int[][] matriz, int vertice) {
		int maiorValor = 0;

		Integer[][] novaMatriz = new Integer[matriz.length * 2][2];
		for (int i = 0; i < vertices; ++i) {
			novaMatriz[i][0] = matriz[i][0];
			novaMatriz[i][1] = matriz[i][1];
			boolean existeCaminhoInversio = false;
			for (int j = 0; j < vertices; ++j) {
				if (matriz[i][0] == matriz[j][1] && matriz[i][1] == matriz[j][0]) {
					existeCaminhoInversio = true;
				}
			}
			if (!existeCaminhoInversio) {
				novaMatriz[i + vertices][0] = matriz[i][1];
				novaMatriz[i + vertices][1] = matriz[i][0];
			}
		}

		for (int i = 0; i < novaMatriz.length; ++i) {
			for (int j = 0; j < novaMatriz[i].length; j++) {
				if (novaMatriz[i][j] != null && novaMatriz[i][j] > maiorValor) {
					maiorValor = novaMatriz[i][j] + 2;
				}
			}
		}

		int[] verticesLista = new int[maiorValor];
		int[] d = new int[maiorValor];
		int[] pi = new int[maiorValor];

		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visitado = new boolean[maiorValor];

		adj = new LinkedList[maiorValor];
		for (int i = 0; i < maiorValor; ++i) {
			adj[i] = new LinkedList<Integer>();
		}

		for (Integer[] veritice : novaMatriz) {
			if (veritice != null && veritice[0] != null && veritice[1] != null) {
				adj[veritice[0]].add(veritice[1]);
			}
		}

		queue.offer(vertice);
		visitado[vertice] = true;
		verticesLista[0] = vertice;
		d[0] = 0;
		pi[0] = 0;
		int index = 0;
		int dIndex = 1;
		while (!queue.isEmpty()) {
			int atualVertice = queue.poll();
			Iterator<Integer> i = adj[atualVertice].listIterator();
			int hasdIndex = 0;
			while (i.hasNext()) {
				int next = i.next();
				if (!visitado[next]) {
					index++;
					verticesLista[index] = next;
					pi[index] = atualVertice;
					d[index] = dIndex;
					visitado[next] = true;
					queue.offer(next);
					hasdIndex++;
				} else {
					hasdIndex--;
				}
			}
			if (hasdIndex > 0) {
				dIndex++;
			}
		}
		System.out.print("  ");
		for (int j = 0; j < verticesLista.length - 1; j++) {
			System.out.print(verticesLista[j] + " ");
		}
		System.out.println();
		System.out.print("d ");
		for (int j = 0; j < d.length - 1; j++) {
			System.out.print(d[j] + " ");
		}
		System.out.println();
		System.out.print("p ");
		for (int j = 0; j < pi.length - 1; j++) {
			System.out.print(pi[j] + " ");
		}
		return "";
	}

	private int[] pre;
	private int[] cor;
	private int[] p;
	private int[] f;
	private int[] pi;
	int tempoCtn = 0;
	int indexDfs = 0;

	public String dfs(int[][] matriz, int vertice) {
		cor = new int[vertices + 1];
		pre = new int[vertices + 1];
		p = new int[vertices + 1];
		f = new int[vertices + 1];
		pi = new int[vertices + 1];
		Integer[][] novaMatriz = new Integer[matriz.length * 2][2];
		for (int i = 0; i < vertices; ++i) {
			novaMatriz[i][0] = matriz[i][0];
			novaMatriz[i][1] = matriz[i][1];
			boolean existeCaminhoInversio = false;
			for (int j = 0; j < vertices; ++j) {
				if (matriz[i][0] == matriz[j][1] && matriz[i][1] == matriz[j][0]) {
					existeCaminhoInversio = true;
				}
			}
			if (!existeCaminhoInversio) {
				novaMatriz[i + vertices][0] = matriz[i][1];
				novaMatriz[i + vertices][1] = matriz[i][0];
			}
		}

		Queue<Integer> queue = new LinkedList<Integer>();

		adj = new LinkedList[novaMatriz.length];
		for (int i = 0; i < novaMatriz.length; ++i) {
			adj[i] = new LinkedList<Integer>();
		}

		for (Integer[] veritice : novaMatriz) {
			if (veritice != null && veritice[0] != null) {
				adj[veritice[0]].add(veritice[1]);
			}
		}

		queue.offer(vertice);
		pi[1] = 0;

		dfst(queue, vertice, 0);
		
		System.out.print("  ");
		for (int j = 1; j < pre.length; j++) {
			System.out.print(pre[j] + "    ");
			if (j == 1) {
				System.out.print(" ");	
			}
		}
		System.out.println();
		System.out.print("d ");
		for (int j = 1; j < p.length; j++) {
			System.out.print(p[j] + "/" + f[j] + "  ");
		}
		System.out.println();
		System.out.print("p ");
		for (int j = 1; j < pi.length; j++) {
			System.out.print(pi[j] + "    ");
			if (j == 1) {
				System.out.print(" ");	
			}
		}
		return null;
	}

	public void dfst(Queue<Integer> g, int u, int oldU) {
		indexDfs++;
		int atualVertice = g.poll();
		cor[u] = 1;
		pre[indexDfs] = atualVertice;
		tempoCtn++;
		p[indexDfs] = tempoCtn;
		pi[indexDfs] = oldU;
		Iterator<Integer> i = adj[atualVertice].listIterator();
		while (i.hasNext()) {
			int next = i.next();
			if (cor[next] == 0) {
				g.offer(next);
				dfst(g, next, u);
			}
		}
		cor[u] = 2;
		tempoCtn++;
		for(int j = 0; j < pre.length; j++) {
			if (pre[j] == u) {
				f[j] = tempoCtn;
			}
		}
	}

}
