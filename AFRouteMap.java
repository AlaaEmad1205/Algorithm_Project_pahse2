/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AirFreightApp;

import GraphFramework.Edge;
import GraphFramework.Vertex;
import GraphFramework.Graph;


/**
 *
 * @author hanee
 */
public class AFRouteMap extends Graph{
    @Override
    public Edge createEdge(Vertex source, Vertex target, int weight) {
        Route route = new Route(source, target, weight);
        return route;
    }

    /**
     *
     * @param label
     * @return
     */
    @Override
    public Vertex createVertex(String label) {
        Location location = new Location(label, "City Name");
        return location;
    }

}
