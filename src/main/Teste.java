package main;

import java.io.FileNotFoundException;

public class Teste {
	private static Ordenacao hp;
	public static Grafo gp;
	private static Vertice ve;
	public static void main(String[] args) throws FileNotFoundException {
		initOrdenacao();
		initGraph();
		Grafo.criaArray("C:/TXT/input.txt");
		/*
		 * saidaArquivo(); DirectGraphList g = new DirectGraphList();
		 * System.out.println(getGrauVertice(5));
		 */
		// geraMatriz(numeros);]
		Ordenacao ord = new Ordenacao();
		gp.criaListaVertice(ord.listaDeVertices(Grafo.arquivo));
		ve = new Vertice(Grafo.vert.get(0).getItem());
		gp.showInfo();
		System.out.println(Grafo.vert.get(0).getDegree());
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
