/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphFramework;
import java.util.*;
import AirFreightApp.*;
/**
 *
 * @author hanee
 */
public class Edge implements Comparable<Edge> {
     public Vertex srcVer;
    public Vertex destVer;
    public Vertex parent;
    public int weight;

    public static ArrayList<Edge> totalEdges = new ArrayList<Edge>();
    
     public Edge(){

    }

    public Edge(Vertex srcVer, Vertex destVer, int weight) {
        this.srcVer = srcVer;
        this.destVer = destVer;
        this.weight = weight;

    }

     public Edge(Vertex srcVer, Vertex destVer, Vertex parent, int weight) {
        this.srcVer = srcVer;
        this.destVer = destVer;
        this.weight = weight;
        this.parent = parent;
    }
    
    public void displayInfo() {
        System.out.println("Office No. "+ srcVer.label+" - Office No. "+destVer.label+" :line length: "+weight);

    }

    @Override
    public int compareTo(Edge o) {
        return (this.weight - o.weight);
    }
}
