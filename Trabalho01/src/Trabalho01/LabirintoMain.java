package Trabalho01;

//Jéssica Maria de Melo Kohn-questão 02
public class LabirintoMain {

	public static void main(String[] args) {
		
	
		int matrizA[][] = { { 13, 13, 13, 13, 13, 13, 13 },
							{ 13, 13, 13, 13, 00, 00, 13 },
							{ 13, 00, 00, 13, 00, -1,  1 },
							{ 13, 13, 13, 13, 00, 13,  2 },
							{ 12, 00, 00, 13, 00, 00,  3 },
							{ 10,  9,  8,  7,  6,  5,  4 },
							{ 11, 00, 00, 13, 13, 13, 13 } };
		
		Labirinto labirinto = new Labirinto();
		
		System.out.println("LABIRINTO");
		System.out.println(labirinto.labirinto(matrizA));
	}

}