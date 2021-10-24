package questao03;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

//Jéssica Maria de Melo Kohn
public class Main {

	static int matrizA[][];

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			long start = System.currentTimeMillis();
			try {
				lerArquivoEProcessar("C:\\Users\\jessica.kohn\\Documents\\graph-theory\\grafo" + (i + 1) + ".txt", 1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long end = System.currentTimeMillis();
			System.out.println("");
			System.out.println("");
			System.out.println("Tempo: " + (end - start));
			System.out.println("------------------------");
			System.out.println("");

		}
	}

	private static void lerArquivoEProcessar(String link, int vertice) throws IOException {
		Grafo.vertices = 5;
		byte[] encoded = Files.readAllBytes(Paths.get(link));
		String grafo = Charset.defaultCharset().decode(ByteBuffer.wrap(encoded)).toString();
		String[] grafos = grafo.split("\r\n");

		matrizA = new int[grafos.length][2];

		for (int i = 0; i < grafos.length; i++) {
			if (i == 0) {
				Grafo.vertices = Integer.parseInt(grafos[i]);
			} else {
				if (!"".equals(grafos[i])) {
					String[] grafosSplited = grafos[i].split(" ");
					int primeiro = Integer.parseInt(grafosSplited[0]);
					int segundo = Integer.parseInt(grafosSplited[1]);
					matrizA[i - 1][0] = primeiro;
					matrizA[i - 1][1] = segundo;
				}
			}
		}

		System.out.println("Busca em largura");
		long start = System.currentTimeMillis();
		new Grafo().bfs(matrizA, vertice);
		long end = System.currentTimeMillis();
		System.out.println();
		System.out.println("Tempo BFS: " + (end - start));
		System.out.println();
		System.out.println();
		System.out.println("Busca em profundidade");
		long start1 = System.currentTimeMillis();
		new Grafo().dfs(matrizA, vertice);
		long end1 = System.currentTimeMillis();
		System.out.println();
		System.out.println("Tempo DFS: " + (end1 - start));
	}

}
