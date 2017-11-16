package main;

class Node implements Comparable<Node>{
	  int altura;
	  
	  public Integer heuristica = null;

	  /*
	  // tabu -> Tabuleiro a associar ao nó
	  // altura -> altura do nó
	  // heur -> tipo de heuristica: 0 altura + manhattan distance e 1 manhattan distance outros nao sao calculados
	  // target -> tabuleiro ao qual queremos chegar
	  */
	  public Node(int altura){
	    this.altura = altura;
	  }

	  @Override
	  public int compareTo(Node p) {
	    if(this.heuristica < p.heuristica)
	      return -1;
	    else
	      return 1;
	  }
	}
