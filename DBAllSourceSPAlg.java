/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphFramework;

import AirFreightApp.Route;
import java.util.ArrayList;
import GraphFramework.Edge;
import AirFreightApp.Location;
import AirFreightApp.Route;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author hanee
 */
public class DBAllSourceSPAlg extends ShortestPathAlgorithm{

    public DBAllSourceSPAlg(Graph graph){
        super(graph);
    }

  
    public void computeDijkstraAlg(int numOfVertices){
        
        //form single to rest of vertices
        int numVertices = numOfVertices;
       
        

        for (int sourceVertex = 0; sourceVertex < numVertices; sourceVertex++) {
            
            
             SingleSourceSPAlg single = new SingleSourceSPAlg(graph);
          
            //char charLabel=graph.verList.get(sourceVertex).label.charAt(0);
           
            
            System.out.println("The starting point location is " + (char) (sourceVertex+ 65) );
            System.out.println("The routes from location " + (char)  (sourceVertex + 65) + " to the rest of the locations are:"  );
           
           
                    
            single.computeDijkstraBasedSPAlg(graph.verList.get(sourceVertex).label, numVertices);
            
            
           
        }

    }

    
   // @Override
    //public void displayResultingMST(int source) {
        /*
        System.out.println("db");

            System.out.println("The Starting point location is:");

            // Initialize a list to store the routes
            ArrayList<Route> routes = new ArrayList<>();
            for (Edge edge : Edge.totalEdges) {
                if (edge instanceof Route) {
                    routes.add((Route) edge);
                }
            }
            // Sort the routes based on weights
            Collections.sort(routes, Comparator.comparingInt(r -> r.weight));

            Location location = new Location("A", "City");

            for (Route route : routes) {
                System.out.print("loc. " + route.srcVer.getLabel() + ": " + location.getCity());
                System.out.print(" - loc. " + route.destVer.getLabel() + ": " + location.getCity());
                System.out.println(" --- route length " + route.weight);
            }
         */
       // }

}
