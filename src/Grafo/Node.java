package Grafo;

import java.util.ArrayList;
import java.util.List;

public class Node {
	public int dado;
	public boolean visitados;
	List<Node> vizinhos;

	Node(int dado)
	{
		this.dado=dado;
		this.vizinhos=new ArrayList<>();

	}
	public void addVizinho(Node vizinhoNo)
	{
		this.vizinhos.add(vizinhoNo);
	}
	public List<Node> getVizinho() {
		return vizinhos;
	}
	public void setVizinho(List<Node> vizinhos) {
		this.vizinhos = vizinhos;
	}
}
