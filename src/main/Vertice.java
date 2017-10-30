package main;

import java.util.ArrayList;

public class Vertice
{	
    public String item;
    private boolean Visitado;
    int maiorSequencia;
    public Vertice proximo;
    public ArrayList<Vertice> lst = new ArrayList<Vertice>();

    public Vertice(String item) {
        this.item = item;
        Visitado=false;
        maiorSequencia=0;
        lst=new ArrayList<Vertice>();
        proximo=null;
    }
    public String getItem() {
        return this.item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public void addAdjacent(Vertice v) {
        if (!lst.contains(v))
            lst.add(v);
    }
    public ArrayList<Vertice> getAdjacents() {
        return lst;
    }
    public Vertice getAdjacent(int i) {
        Vertice res = null;
        if ((i >= 0) && (i < lst.size()))
            res = lst.get(i);
        return res;
    }
    public int getDegree(){
        return lst.size(); 
    }
    
    
}
