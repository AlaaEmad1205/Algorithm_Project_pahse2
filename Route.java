/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirFreightApp;

import GraphFramework.Edge;
import GraphFramework.Vertex;

/**
 *
 * @author hanee
 */
public class Route extends Edge {

    public Route(Vertex source, Vertex target, Vertex parent, int weight) {
        super(source, target, parent, weight);
    }

    public Route(Vertex source, Vertex target, int weight) {
        super(source, target, weight);
    }
    
    @Override
    public void displayInfo(){
        System.out.println("--- route length: ");    }
    
}
