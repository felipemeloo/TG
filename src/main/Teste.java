package main;

import java.io.FileNotFoundException;
import java.util.Scanner;

import Grafo.CriaGrafo;
import Grafo.Vertice;
import GrafoPeso.Dijkstra;
import GrafoPeso.Grafo;


public class Teste {
	private static Ordenacao hp;
	public static CriaGrafo gp;
	public static Grafo gr;
	
	private static Vertice ve;
	private static Dijkstra dj;
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Inicio do processo: "+new java.util.Date().toString());
		initOrdenacao();
		System.out.println("Digite o nome do arquivo");
		Scanner ler = new Scanner(System.in);
	    String nome = ler.nextLine();
	    initGraph(nome);
	    if(!gp.comPeso){
	        System.out.println("inicio lista adjacencia"+new java.util.Date().toString());
		    gp.criaListaVertice(gp.arquivo);
		    System.out.println("fim lista adjacencia"+new java.util.Date().toString());
		    System.out.println("inicio matriz adjacencia"+new java.util.Date().toString());
		    gp.geraMatriz(gp.arquivo);
		    System.out.println("inicio matriz adjacencia"+new java.util.Date().toString());
			gp.showInfo();
	    }
	    
	    
	    
	    
	    initGrafoPeso(gp.arquivo.get(0).intValue());// instancia a classe e o grafo
	    initDijakstra(gr);
	    gp.criaListaVertice(gp.arquivo);
	    try {
			dj.obterArvoreCMC(1);// parametro e a raiz do grafo
			dj.imprimeCaminho(1,1);// primeiro parametro raiz e o segundo onde deseja chegar
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void initOrdenacao() {
		if (hp == null) {
			hp = new Ordenacao();

		}
	}

	public static void initGraph(String nome) {
		if (gp == null) {
			gp = new CriaGrafo(nome);

		}
	}
	public static void initGrafoPeso(int g) {
		if (gr == null) {
			gr = new Grafo(g);
			
		}
	}
	public static void initDijakstra(Grafo g) {
		if (dj == null) {
			dj = new Dijkstra(g);
			
		}
	}
}