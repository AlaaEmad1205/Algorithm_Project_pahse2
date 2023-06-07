/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import GraphFramework.Edge;
import AirFreightApp.*;
import static javafx.scene.AccessibleAttribute.VALUE;


/**
 *
 * @author hanee
 */
public class SingleSourceSPAlg extends ShortestPathAlgorithm {
            String[] ThePath;
            int[]  Smallest_Distances;
    public SingleSourceSPAlg(Graph graph) {
        super(graph);
    }

    
   public void computeDijkstraBasedSPAlg(String sourceStr, int numOfVertices) {

       int Infinity = Integer.MAX_VALUE;
       
       int VerticesNumber = numOfVertices;
       
       int Source=0;
       
       for(int i=0; i<VerticesNumber; i++)
       {
           
           if (i >= Source)
           {
               
           if (graph.verList.get(i).label.equals(sourceStr))
           {
              Source = i; 
           }
           
           }
       }
       
      

   
     String SourceLabel = graph.verList.get(Source).label;
     
     int SourceLabelInt = Integer.parseInt(SourceLabel);
        
        
        //intilize array
       Smallest_Distances = new int[VerticesNumber];
       ThePath   = new String[VerticesNumber];


        //update all the vertices smallestDistance as infinity
        for (int i = 0; i < VerticesNumber; i++) 
        {
            if (i >= Source){
            for (int j = 0; j < VerticesNumber; j++)
            Smallest_Distances[i] = Infinity;
            }
        }
            
       
        //make the distance of the source vertex 0
       Smallest_Distances[Source] = 0;

       
                ThePath[Source] = graph.verList.get(Source).label  + " --" + Smallest_Distances[Source] + "--> ";
         
        for (int i = 0; i < VerticesNumber; i++) {
           
            
            if (i >= Source)
            { 
             
            
            // Find the minium smallestDistance among all the vertices adjacent 
            //----
            //this part act like the PQ to find the smallest distance
                
             int x = 0;
            int Minimum_Distance = Infinity;
            for (int j = 0; j < VerticesNumber; j++) {
                if (i >= Source){
                if (!graph.verList.get(j).isVisited && Smallest_Distances[j] < Minimum_Distance) {
                    Minimum_Distance = Smallest_Distances[j];
                    x = j;
                }
                
                }
            }
            
            
            //Once the smallest is found
            graph.verList.get(x).isVisited = true;
            
               //Update the adjacent distances   
            for (int vert = 0; vert < VerticesNumber; vert++) {
                
                if (i >= Source){
                    
                if (!graph.verList.get(vert).isVisited && EdgeWeight(x, vert) != Infinity && EdgeWeight(x, vert) != 0) {
                    
                  
                    if (Smallest_Distances[x] + EdgeWeight(x, vert) < Smallest_Distances[vert]) 
                    {
                        //update the smallest distance 
                        Smallest_Distances[vert] = Smallest_Distances[x] + EdgeWeight(x, vert);
                        
                        // Update the path too
                        ThePath[vert] = ThePath[x] + (char) (vert + 65) + " --" + (Smallest_Distances[vert] - Smallest_Distances[x]) + "--> ";
                    }
                }
                
                
            }
            }
            
           
         
        }
       
        }
        
      
          
        
          //update all the vertices smallestDistance as infinity
        for (int i = 0; i < VerticesNumber; i++) {
            if (i >= Source)
            graph.verList.get(i).isVisited= false;
        }
        
          for (int i = 0; i < VerticesNumber; i++) {
              if (i >= Source){
           
            String label = graph.verList.get(i).label;
           int IntLable = Integer.parseInt(label);
          
           displayshortestPath ();
             //System.out.println("---> Shortest Distance from "+ SourceLabelInt+ " to '" + IntLable  + "' is " + Smallest_Distances[i] + ", the Path: " + ThePath[i] + " " );
              }
        }
          
                       System.out.println("--------------------------------------------------------------- \n" );
                       
                       
        
   }

    private int EdgeWeight(int u, int v) {
        for (Edge edge : Edge.totalEdges) {
            if (edge.srcVer.label.equals(graph.verList.get(u).label) && edge.destVer.label.equals(graph.verList.get(v).label)) {
                return edge.weight;
            }
        }
        return 0;
    }
   
    
    
    public void displayshortestPath (){
        
        for (int i = 0; i < graph.verList.size(); i++) {
            
        
            
                String label = graph.verList.get(i).getLabel();
                
                if (ThePath[i] != null){
                    for (int o = 0; o < ThePath.length ; o++) {
                        
                    System.out.println("loc. "+ ThePath[i].charAt (o)+ ": city "+(o+ 1) +" " + "-- route length:");
                }
                    //System. out.print("-- route length:");
                    
                    if(Smallest_Distances[i] == Integer.MAX_VALUE  || Smallest_Distances [i] == 0){
                    System.out.println ("No path");
                }else{
                        System.out.println(Smallest_Distances [i]) ;
                        
                    }
                  
                   
                


            }
        }
        







}
}

