package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DirectGraphList {
	private static Ordenacao hp;
	private ArrayList<Vertice> vert;
	static ArrayList<Integer> numeros = new ArrayList<Integer>();
	private static DirectGraphList gp;

	public DirectGraphList() {
		vert = new ArrayList<Vertice>();
	}

	private Vertice searchVerticeRef(String item) {
		Vertice res = null;
		int i;

		for (i = 0; ((i < vert.size()) && !vert.get(i).getItem().equals(item)); i++)
			;

		if (i < vert.size())
			res = vert.get(i);

		return res;
	}

	public void addVertice(String item) {
		if (searchVerticeRef(item) == null) {
			Vertice novo = new Vertice(item);
			vert.add(novo);
		}
	}

	public void criaListaVertice(ArrayList<Integer> lista) {
		int matriz[][] = new int[lista.get(0)][lista.get(0)];

		for (int i = 0; i < lista.size(); i++) {
			addVertice(lista.get(i).toString());
		}
		for (int i = 0; i < lista.size(); i++) {
			for (int j = 0; j < lista.size(); j++) {
				Vertice v = new Vertice(String.valueOf(i));
				Vertice adj = new Vertice(String.valueOf(j));
				matriz = geraMatriz(numeros);
				if (matriz[i][j] == 1) {
					v.addAdjacent(adj);
				}
			}
		}
	}

	public void addEdge(String strOrig, String strDest) {
		Vertice vAux1 = searchVerticeRef(strOrig);
		Vertice vAux2 = searchVerticeRef(strDest);

		if (vAux1 == null)
			throw new IllegalArgumentException("Aresta origem invalida: " + strOrig);
		else if (vAux2 == null)
			throw new IllegalArgumentException("Aresta destino invalida: " + strDest);
		else {
			vAux1.addAdjacent(vAux2);
		}
	}

	public int getNumVertices() {
		return vert.size();
	}

	public int getDegree(String vertice) {
		int i, j, c = 0;
		Vertice v = searchVerticeRef(vertice);
		if (v != null) {
			// grau de saida
			c += v.getDegree();

			// grau de entrada
			for (i = 0; i < vert.size(); i++) {
				if (!vert.get(i).getItem().equals(vertice)) {
					for (j = 0; j < vert.get(i).getDegree(); j++) {
						if (vert.get(i).getAdjacent(j).getItem().equals(vertice))
							c++;
					}
				}
			}
		}
		return c;
	}

	public ArrayList<String> getAllAdjacents(String vertice) {
		ArrayList<String> res = null;
		Vertice v = searchVerticeRef(vertice);
		if (v != null) {
			res = new ArrayList<String>();
			for (int j = 0; j < v.getDegree(); j++)
				res.add(v.getAdjacent(j).getItem());
		}
		return res;
	}

	public ArrayList<String> getSources() {
		ArrayList<String> res = new ArrayList<String>();
		boolean checked;
		String vertice;

		for (int k = 0; k < vert.size(); k++) {
			vertice = vert.get(k).getItem();

			checked = false;
			for (int i = 0; i < vert.size(); i++) {
				for (int j = 0; j < vert.get(i).getDegree(); j++) {
					if (vert.get(i).getAdjacent(j).getItem().equals(vertice)) {
						checked = true;
						break;
					}
				}
			}

			if (!checked)
				res.add(vertice);
		}
		return res;
	}

	public ArrayList<String> getSinks() {
		ArrayList<String> res = new ArrayList<String>();

		for (int i = 0; i < vert.size(); i++) {
			if (vert.get(i).getAdjacents().isEmpty())
				res.add(vert.get(i).getItem());
		}
		return res;
	}

	public void showInfo() {
		System.out.print("V = { ");
		for (int i = 0; i < vert.size() - 1; i++)
			System.out.printf("%s, ", vert.get(i).getItem());
		System.out.printf("%s }\n", vert.get(vert.size() - 1).getItem());

		ArrayList<String> arestas = new ArrayList<String>();
		for (int i = 0; i < vert.size(); i++)
			for (int j = 0; j < vert.get(i).lst.size(); j++)
				arestas.add(String.format("(%s, %s)", vert.get(i).getItem(), vert.get(i).getAdjacent(j).getItem()));

		System.out.print("E = {\n");
		if (!arestas.isEmpty()) {
			System.out.printf("      %s", arestas.get(0));

			for (int i = 1; i < arestas.size(); i++)
				System.out.printf(",\n      %s", arestas.get(i));
		}
		System.out.println("\n    }");
	}

	public static void criaArray(ArrayList<Integer> a, String nome) throws FileNotFoundException {
		int tamanhoIn = 0;
		int tamanhoAt = 0;
		int cont = 1;
		String parcial = null;
		try {
			FileReader ler = new FileReader(nome);
			BufferedReader arq = new BufferedReader(ler);
			int parsedStr;
			String str = arq.readLine();
			tamanhoIn = str.length();
			while (str != null) {
				while (tamanhoAt != tamanhoIn) {
					if (!str.substring(tamanhoAt, cont).equalsIgnoreCase(" ")) {
						parcial = str.substring(tamanhoAt, cont);
						parsedStr = Integer.parseInt(parcial);
						a.add(parsedStr);
					}
					tamanhoAt++;
					cont = tamanhoAt + 1;
				}
				cont = 1;
				tamanhoAt = 0;
				str = arq.readLine();
				if (str != null) {
					tamanhoIn = str.length();
				} else
					break;
			}
		} catch (IOException e) {
			System.out.println("Erro na abertura do arquivo: " + e.getMessage());
		}
	}

	public static void saidaArquivo() {
		// ArrayList<Integer> ordenados= hp.heapSort(numeros);
		File arquivo = new File("C:/TXT/saida.txt");
		try (PrintWriter pw = new PrintWriter(arquivo)) {
			pw.println("# n =" + numeros.get(0));
			pw.println("# m =" + ((numeros.size() - 1) / 2));
			// double d_medio = 2* numeros.get(0)/ numeros.size()-1/2;
			for (int i = 0; i < numeros.size(); i++) {
				if (i % 2 != 0) {
					pw.print(i);
					pw.println(" " + getGrauVertice(i));
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static int getGrauVertice(Integer vertice) {
		int grau = 0;
		for (Integer s : numeros) {
			if (s == vertice)
				grau++;
		}
		if (vertice == numeros.get(0)) {
			grau--;
		}
		return grau;
	}

	public static int diferente(String a, String b) {
		int diferentes = 0;
		if (a.length() == b.length()) {
			for (int i = 0; i < a.length(); i++) {
				if (a.charAt(i) != b.charAt(i))
					diferentes++;
			}
		} else
			diferentes = 2;
		return diferentes;
	}

	public static boolean maior(String str1, String str2) {
		int aux = Integer.parseInt(str1, 6);
		int aux1 = Integer.parseInt(str2, 6);
		if (aux > aux1)
			return true;
		else
			return false;
	}

	public static boolean possibilidades(DirectGraphList graph, String a, ArrayList<Integer> array) {
		int diferentes = 0;
		for (int i = 0; i < array.size(); i++) {
			String numero = Integer.toString(array.get(i), 6);
			diferentes = diferente(numero, a);
			if (diferentes == 1 && maior(numero, a)) {
				graph.addEdge(a, numero);
			}
		}
		return true;
	}

	public void printaSequencia(Vertice a) {
		System.out.println(a.item);
		Vertice atual = a;
		while (atual.proximo != null) {
			atual = atual.proximo;
			System.out.println(atual.item);
		}
	}

	public void atribuiTamanhoSequencia() {
		for (int i = vert.size() - 1; i >= 0; i--) {
			vert.get(i).maiorSequencia = 1;
			for (int k = vert.get(i).lst.size() - 1; k >= 0; k--) {
				if (vert.get(i).lst.get(k).maiorSequencia + 1 > vert.get(i).maiorSequencia) {
					vert.get(i).maiorSequencia = vert.get(i).lst.get(k).maiorSequencia + 1;
					vert.get(i).proximo = vert.get(i).lst.get(k);
				}
			}
		}

	}

	public Vertice getVerticeInicial() {
		Vertice aux = null;
		int tamanho = 0;
		for (int i = 0; i < vert.size(); i++) {
			if (vert.get(i).maiorSequencia > tamanho) {
				aux = vert.get(i);
				tamanho = vert.get(i).maiorSequencia;
			}
		}
		return aux;
	}

	public static int[][] geraMatriz(ArrayList<Integer> a) {
		int matriz[][] = new int[a.get(0)][a.get(0)];
		int j = 2;
		for (int i = 1; i < a.size(); i += 2, j += 2) {
			matriz[a.get(j) - 1][a.get(i) - 1] = 1;
			matriz[a.get(i) - 1][a.get(j) - 1] = 1;
		}
		for (int i = 1; i < a.get(0); i++) {
			for (j = 1; j < a.get(0); j++) {
				if (matriz[i][j] != 1) {
					matriz[i][j] = 0;
				}
			}
		}

		// for(int i=0;i<a.get(0);i++){
		// for(j=0;j<a.get(0);j++){
		// System.out.print(matriz[i][j]);
		//
		// }System.out.println();
		// }
		return matriz;
	}

	public static void main(String[] args) throws FileNotFoundException {
		initOrdenacao();
		initGraph();
		criaArray(numeros, "C:/TXT/input.txt");
		/*
		 * saidaArquivo(); DirectGraphList g = new DirectGraphList();
		 * System.out.println(getGrauVertice(5));
		 */
		// geraMatriz(numeros);]
		Ordenacao ord = new Ordenacao();
		gp.criaListaVertice(ord.listaDeVertices(numeros));
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
			gp = new DirectGraphList();

		}
	}
}