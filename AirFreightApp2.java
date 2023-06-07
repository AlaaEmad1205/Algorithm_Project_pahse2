/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirFreightApp;
//import static AirFreightApp.AirFreightApp.map;
import GraphFramework.ShortestPathAlgorithm;


import GraphFramework.ShortestPathAlgorithm;
import GraphFramework.SingleSourceSPAlg;
import GraphFramework.DBAllSourceSPAlg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *
 * @author hanee
 */
public class AirFreightApp2 {
    
    static AFRouteMap map;

    public static void main(String[] args) throws FileNotFoundException {
        
        
        int verticesNo = 0; //number of vertices
        int edgesNo = 0;    //number of edges
        int caseNumber =0;  //choice of casses
        
        
         // Create objects
        Scanner input = new Scanner(System.in);
        map = new AFRouteMap();
        

        System.out.println("(((( Efficient Air freight system of transporting goods: Powered by Dijkstra algorithm ))))\n\n");
        System.out.print("Type 1 to Upload a File or type 2 to Generate a Random Graph: ");
        int option = input.nextInt();
        
        if (option == 2){
            do{
            // Apply makeGraph() method
                System.out.println("\n\n--------------------- Choose From 1 to 5 ------------------");
                System.out.println("*** where n = number of vertices and m = number of edges ***");
                System.out.println("*** These are the available cases: ***");
                System.out.println("    1) n=2,000  ***  m=10,000  "
                        + "\n    2) n=3,000  ***  m=15,000  "
                        + "\n    3) n=4,000  ***  m=20,000  "
                        + "\n    4) n=5,000  ***  m=25,000  "
                        + "\n    5) n=6,000  ***  m=30,000  "
                        + "\n-------------------------------");
                System.out.print("Your choice: ");
                caseNumber = input.nextInt();
                
                
                switch(caseNumber){
            case 1:
                verticesNo = 2000;
                edgesNo = 10000;
                break;
            case 2:
                verticesNo = 3000;
                edgesNo = 15000;
                break;
            case 3:
                verticesNo  = 4000;
                edgesNo = 20000;
                break;
            case 4:
                verticesNo  = 5000;
                edgesNo = 25000;
                break;
            case 5:
                verticesNo  = 6000;
                edgesNo = 30000;
                break;
           
               }//end
                
            }while (!(caseNumber >= 1 && caseNumber <= 5));
            
            map.makeGraph(2, 10);
            
            System.out.println(map.verList.size());
            
             System.out.println("");
        
         DBAllSourceSPAlg alg1 = new DBAllSourceSPAlg(map);
        
        long startTime = System.nanoTime();
        int sourceIndex = 0;
        
         alg1.computeDijkstraAlg(map.verList.size());
         
       /* if (sourceIndex >= 0 && sourceIndex < map.verticesNo) {
           alg1.computeDijkstraAlg();
        
        
        } else {
            System.out.println("Invalid source index");
        }  */
        
              long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("------------------------------------------------\n"
                + "Total time elapsed (Single Source Algorithm) : " + elapsedTime);

        System.out.println("\n");
            
                
        }
        
        else if (option == 1){
            // Read graph from file
            File fileName = new File("graph.txt");
            map.readGraphFromFile(fileName);
            
             System.out.println("");
        
         DBAllSourceSPAlg alg1 = new DBAllSourceSPAlg(map);
        
        long startTime = System.nanoTime();
        int sourceIndex = 0;
        if (sourceIndex >= 0 && sourceIndex < map.verticesNo) {
           alg1.computeDijkstraAlg(map.verList.size());
        
        
        } else {
            System.out.println("Invalid source index");
        }
        
              long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("------------------------------------------------\n"
                + "Total time elapsed (Single Source Algorithm) : " + elapsedTime);

        System.out.println("\n");
        }
        
       
      
    }
}
