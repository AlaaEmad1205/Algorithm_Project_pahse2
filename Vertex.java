/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphFramework;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author hanee
 */
public class Vertex implements Comparable<Vertex>{
     // DATA FIELD
    public String label;
    public boolean isVisited ;

    public int parent = -1; // LABEL OF PARENT VERTEX -> INITIAL VALUE -1 
    public int rank = 0;
    public int key = Integer.MAX_VALUE;
    
    static public ArrayList<LinkedList<Edge>> adjList = new ArrayList<>(); // ADJACENCY LIST

    public Vertex(){

    }

    public Vertex(String label){
        this.label = label;


    }
    public String getLabel() {
        return label;
    }


    public void displayInfo(){
        System.out.println("Vertex: " + label);
    }

    @Override
    public int compareTo(Vertex o) {
        return (this.key - o.key);
    }
    
}
