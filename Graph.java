/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphFramework;
import java.io.*;
import java.util.*;
import AirFreightApp.*;
/**
 *
 * @author hanee
 */
public abstract class Graph {
    
    public int verticesNo;
    public int edgeNo;
    public boolean isDigraph = false;
    public ArrayList<Vertex> verList = new ArrayList<>();

    public Graph() {
    }

    public Graph(int verticesNo, int edgeNo, boolean isDigraph) {
        this.verticesNo = verticesNo;
        this.edgeNo = edgeNo;
        this.isDigraph = isDigraph;
        verList = new ArrayList<>(verticesNo);
    }

    public Graph readGraphFromFile(File filename) {

        try (Scanner in = new Scanner(filename)) {

            in.next();
            isDigraph = (in.nextInt() == 1);

            verticesNo = in.nextInt();
            edgeNo = in.nextInt();

            for (int i = 0; i < edgeNo; i++) {

                int srcLabel =  in.next().charAt(0);
                int destLabel = in.next().charAt(0);
                int edgeWeight = in.nextInt();

                // search for src
                Vertex src = searchVertex(srcLabel);

                // search for dest
                Vertex dest = searchVertex(destLabel);

                // create house object for the new house
                if (src == null) {
                    // src ver
                    src = createVertex(String.valueOf(srcLabel));
                    verList.add(src);
                }

                if (dest == null) {
                    dest = createVertex(String.valueOf(destLabel));
                    verList.add(dest);
                }

                addEdge(src, dest, edgeWeight);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }

        return this;
    }

    public Graph makeGraph(int verticesNo, int edgeNo) {
        Graph graph = new Graph() {
            @Override
            public Vertex createVertex(String label) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public Edge createEdge(Vertex srcVer, Vertex destVer, int weight) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };

        Random random = new Random();

        for (int i = 0; i < verticesNo; i++) {
            Vertex ver = createVertex(String.valueOf(i));
            verList.add(ver);
        }

        for (int i = 0; i < verticesNo - 1; i++) {
            int weight = random.nextInt(50) + 1;

            if ((i + 1) > verticesNo - 1) {
                addEdge(verList.get(i), verList.get(0), weight);
                graph.edgeNo++;
                continue;
            }

            addEdge(verList.get(i), verList.get(i + 1), weight);
            graph.edgeNo++;

            if (!graph.isDigraph) {
                addEdge(verList.get(i + 1), verList.get(i), weight);
                graph.edgeNo++;
            }
        }

        int remEdge = edgeNo - (verticesNo - 1);

        for (int i = 0; i < remEdge; i++) {
            int srcVert = random.nextInt(verticesNo);
            int destVert = random.nextInt(verticesNo);

            if (destVert == srcVert || checkEdge(srcVert, destVert)) {
                i--;
                continue;
            }

            int weight = random.nextInt(50) + 1;
            addEdge(verList.get(srcVert), verList.get(destVert), weight);
            graph.edgeNo++;

            if (!graph.isDigraph) {
                addEdge(verList.get(destVert), verList.get(srcVert), weight);
                graph.edgeNo++;
            }
        }

        return graph;
    }

    public void addEdge(Vertex srcVer, Vertex destVer, int weight) {
        Edge newEdge = createEdge(srcVer, destVer, weight);
        newEdge.parent = new Location(String.valueOf(-1), "City Name");

        if (Location.adjList.size() <= Integer.parseInt(srcVer.label)) {
            for (int i = Location.adjList.size(); i <= Integer.parseInt(srcVer.label); i++) {
                Location.adjList.add(new LinkedList<>());
            }
        }

        Location.adjList.get(Integer.parseInt(srcVer.label)).add(newEdge);
        Edge.totalEdges.add(newEdge);
    }


    public boolean checkEdge(int src, int dest) {
        for (int i = 0; i < Location.adjList.size(); i++) {
            for (int j = 0; j < Location.adjList.get(i).size(); j++) {
                Edge temp = Location.adjList.get(i).get(j);
                if (temp.destVer.label.equals(String.valueOf(dest)) && temp.srcVer.label.equals(String.valueOf(src))) {
                    return true;
                }
            }
        }
        return false;
    }

    private Vertex searchVertex(int src) {
        for (int i = 0; i < verList.size(); i++) {
            if (Integer.parseInt(verList.get(i).label) == src) {
                return verList.get(i);
            }
        }
        return null;
    }

    public abstract Vertex createVertex(String label);

    public abstract Edge createEdge(Vertex srcVer, Vertex destVer, int weight);
}