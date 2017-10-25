package main;

import java.util.ArrayList;
import java.util.Collections;


public class Ordenacao{
	public ArrayList<Integer> ordena(ArrayList<Integer> unsortedList){
	Collections.sort(unsortedList);
	return unsortedList;
	}
	public ArrayList<Integer> listaDeVertices(ArrayList<Integer> unsortedList){
		 ArrayList<Integer> retorno= new ArrayList<Integer>(unsortedList);
		 retorno.remove(0);
		Collections.sort(retorno);
	int atual;
	int prox;
	  for(int i=0; i< retorno.size();) {
		  if(i+1==retorno.size()) 
		  {break;}
		  atual=retorno.get(i);
		  prox=retorno.get(i+1);
		  if(atual==prox) {
			  retorno.remove(i);
			  if(i!=0) {
			  i--;
			 }else 
				 i=0;
		  }else  
			  i++;
	  }
	return retorno;
	}
	public static boolean estaOrdenado(ArrayList<Integer> sortedList)
	{
		boolean sorted = true;
		for(int i = 0; i < sortedList.size() - 1; i++)
		{
			if(sortedList.get(i) > sortedList.get(i + 1))
			{
				sorted = false;
				break;
			}
		}
		return sorted;
	}
}