package com.company;

import java.util.ArrayList;
import java.util.Collection;

public interface GraphADT<V,E> {
    Vertex<V> addVertex (V value);

    Vertex<V> removeVertex (Vertex<V> vertex);

    Edge<E> addEdge (Vertex<V> from, Vertex<V> to,E weight, E bandwidth);

    Edge<E> removeEdge (Edge<E> edge);

    ArrayList<Edge<E>> edgesFrom (Vertex<V> vertex);

    ArrayList<Edge<E>> edgesTo (Vertex<V> vertex);

    Vertex<V> findVertex(V value);

    Edge<E> findEdge (V from_value, V to_value);

    boolean hasEdge(Vertex<V> v, Vertex<V> u);



}
