package main;

import java.io.FileNotFoundException;
import java.util.Scanner;

import Grafo.CriaGrafo;
import Grafo.Graph;
import Grafo.Vertice;


public class Teste {
	private static Ordenacao hp;
	public static CriaGrafo gp;
	private static Vertice ve;
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Inicio do processo: "+new java.util.Date().toString());
		initOrdenacao();
		initGraph();
		System.out.println("Digite o nome do arquivo");
		Scanner ler = new Scanner(System.in);
	    String nome = ler.nextLine(); // 3.5 entrada de dados (lendo uma String)
//		as_graph
		CriaGrafo.criaArray(nome);
		In in = new In(args[0]);
		Graph G = new Graph(in);
		System.out.println(G);
		/*
		 * saidaArquivo(); DirectGraphList g = new DirectGraphList();
		 * System.out.println(getGrauVertice(5));
		 */
		// geraMatriz(numeros);]
		Ordenacao ord = new Ordenacao();
		//ve = new Vertice(Grafo.vert.get(0).getItem());
//	    System.out.println("inicio matriz adjacencia"+new java.util.Date().toString());
//	    gp.geraMatriz(Grafo.arquivo);
//	    System.out.println("fim matriz adjacencia"+new java.util.Date().toString());
		//gp.showInfo();
	    System.out.println("inicio lista adjacencia"+new java.util.Date().toString());
		gp.criaListaVertice(ord.listaDeVertices(CriaGrafo.arquivo));
	    System.out.println("fim lista adjacencia"+new java.util.Date().toString());
		gp.showInfo();
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
			gp = new CriaGrafo();

		}
	}
}