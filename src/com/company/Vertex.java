package com.company;

public class Vertex<T> {
    T name;
    boolean isVisited;

    Vertex(T name){
        this.name = name;
        isVisited = false;
    }
}
