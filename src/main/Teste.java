package main;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class Teste {
	private static Ordenacao hp;
	public static Grafo gp;
	private static Vertice ve;
	public static void main(String[] args) throws FileNotFoundException {
		initOrdenacao();
		initGraph();
		System.out.println("Digite o nome do arquivo");
		Scanner ler = new Scanner(System.in);
	    String nome = ler.nextLine(); // 3.5 entrada de dados (lendo uma String)
//		as_graph
		Grafo.criaArray("/home/felipe/Documentos/"+nome);
		/*
		 * saidaArquivo(); DirectGraphList g = new DirectGraphList();
		 * System.out.println(getGrauVertice(5));
		 */
		// geraMatriz(numeros);]
		Ordenacao ord = new Ordenacao();
		//ve = new Vertice(Grafo.vert.get(0).getItem());
	    //gp.geraMatriz(Grafo.arquivo);
		//gp.showInfo();
		//gp.criaListaVertice(ord.listaDeVertices(Grafo.arquivo));
		//gp.showInfo();
		//System.out.println(Grafo.vert.get(0).getDegree());
		
//		bl.percorrerAdjacente()
		/*
		 * hp.heapSort(numeros); for(int j=0;j<numeros.size();j++){
		 * g.addVertice(Integer.toString(numeros.get(j),6)); } for(int
		 * i=0;i<numeros.size();i++){ String numer=Integer.toString(numeros.get(i), 6);
		 * possibilidades(g,numer,numeros); } g.atribuiTamanhoSequencia(); Vertice
		 * inicial=g.getVerticeInicial(); g.printaSequencia(inicial);
		 */
	}

	public static void initOrdenacao() {
		if (hp == null) {
			hp = new Ordenacao();

		}
	}

	public static void initGraph() {
		if (gp == null) {
			gp = new Grafo();

		}
	}
}