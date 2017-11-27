package main;

import java.util.List;
import java.util.Stack;

import Grafo.Node;

public class Buscas{

	public  void buscaEmProfundidade(Node node)
	{
		Stack<Node> pilha=new  Stack<Node>();
		pilha.add(node);
		node.visitados =true;
		while (!pilha.isEmpty())
		{
			Node elemento = pilha.pop();
			System.out.print(elemento.dado + " ");
 
			List<Node> vizinho = elemento.getVizinho();
			for (int i = 0; i < vizinho.size(); i++) {
				Node n= vizinho.get(i);
				if( n!=null && !n.visitados)
				{
					pilha.add(n);
					n.visitados = true;
 
				}
			}
		}
	}
    }