package com.company;

import java.util.ArrayList;
import java.util.Stack;


public class AdjacencyMatrixGraph<V,E> implements GraphADT<V,E> {

    ArrayList<ArrayList<Edge<E>>> adjacencyMatrix;
    ArrayList<Vertex<V>> listOfVertex;
    Stack<Vertex<V>> visitedVertices;

    AdjacencyMatrixGraph(){
        adjacencyMatrix = new ArrayList<>();
        listOfVertex = new ArrayList<>();
    }
    public int indexOf(Vertex<V> vertex){
        for (int i = 0; i < listOfVertex.size(); i++){
            if (vertex.name == listOfVertex.get(i).name)
                return i;
        }
        return -1;
    }

    @Override
    public Vertex<V> addVertex(V value) {
        Vertex<V> temp = new Vertex<V>(value);

        listOfVertex.add(temp);

        ArrayList<Edge<E>> newRow = new ArrayList<>();
        for(int i = 0; i < listOfVertex.size();++i){
            Edge<E> empty= new Edge<>();
            newRow.add(empty);
        }
        adjacencyMatrix.add(newRow);
        for(int i = 0; i < listOfVertex.size() - 1;++i){
            Edge<E> empty= new Edge<>();
            adjacencyMatrix.get(i).add(empty);
        }

        return temp;
    }

    @Override
    public Vertex<V> removeVertex(Vertex<V> vertex) {

        int x = indexOf(vertex);
        adjacencyMatrix.remove(x);

        for(int i = 0; i < listOfVertex.size() - 1 ;++i){
            adjacencyMatrix.get(i).remove(x);
        }


        listOfVertex.remove(vertex);
        return vertex;
    }

    @Override
    public Edge<E> addEdge(Vertex<V> from, Vertex<V> to, E weight, E bandwidth) {
        int x = indexOf(from);
        int y = indexOf(to);
        if(x!= -1 && y!= -1){
            Edge<E> edge = adjacencyMatrix.get(x).get(y);
            edge.isEmpty = false;
            edge.weight = weight;
            edge.bandwidth = bandwidth;
            return edge;
        }
        return null;
    }

    @Override
    public Edge<E> removeEdge(Edge<E> edge) {
        edge.isEmpty = true;
        return edge;
    }

    @Override
    public ArrayList<Edge<E>> edgesFrom(Vertex<V> vertex) {
        int x = indexOf(vertex);
        if(x == -1){
            return null;
        }
        ArrayList<Edge<E>> listOfSource = new ArrayList<>();
        for(int i = 0; i < listOfVertex.size();++i){
            if(adjacencyMatrix.get(i).get(x) != null)
                listOfSource.add(adjacencyMatrix.get(x).get(i));
        }
        return listOfSource;
    }

    @Override
    public ArrayList<Edge<E>> edgesTo(Vertex<V> vertex) {
        int x = indexOf(vertex);
        if(x == -1){
            return null;
        }
        ArrayList<Edge<E>> listOfSource = new ArrayList<>();
        for(int i = 0; i < listOfVertex.size();++i){
            if(adjacencyMatrix.get(i).get(x) != null)
                listOfSource.add(adjacencyMatrix.get(i).get(x));
        }
        return listOfSource;
    }

    @Override
    public Vertex<V> findVertex(V value) {
        for (int i = 0; i < listOfVertex.size();++i){
            if(listOfVertex.get(i).name.hashCode() == value.hashCode()){
                return listOfVertex.get(i);
            }
        }
        return null;
    }

    @Override
    public Edge<E> findEdge(V from_value, V to_value) {
        Vertex<V> ver1 = findVertex(from_value);
        Vertex<V> ver2 = findVertex(to_value);
        if(ver1 == null || ver2 == null)
            return null;
        int x = indexOf(ver1);
        int y = indexOf(ver2);
        if(x == -1 || y == -1)
            return null;
        return adjacencyMatrix.get(x).get(y);
    }

    @Override
    public boolean hasEdge(Vertex<V> v, Vertex<V> u) {
        if(v == null || u == null)
            return false;
        int x = indexOf(v);
        int y = indexOf(u);
        if(x == -1 || y == -1)
            return false;

        if(adjacencyMatrix.get(x).get(y).isEmpty){
            return false;
        }

        return true;
    }

    public ArrayList<ArrayList<Edge<E>>> printMatrix(){
        for( int i = 0; i < listOfVertex.size(); ++i){
            for (int j = 0; j < listOfVertex.size();++j){
                if (!adjacencyMatrix.get(i).get(j).isEmpty){
                    System.out.print(adjacencyMatrix.get(i).get(j).weight + " ");
                }
                else{
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        return adjacencyMatrix;
    }

    public boolean isAcyclic(Vertex<V> vertex){
        boolean t = DFS(vertex);



        return false;
    }
    boolean DFS(Vertex<V> vertex)
    {
       int x = indexOf(vertex);
       if(x!= -1){
           visitedVertices.push(vertex);
           vertex.isVisited = true;
           for(int i = 0;i < listOfVertex.size();++i){
               if(adjacencyMatrix.get(x).get(i) != null){
                   if(!listOfVertex.get(i).isVisited){
                       DFS(listOfVertex.get(i));
                   }
                   else{
                       return false;
                   }
               }
           }

       }
       return true;

    }

}