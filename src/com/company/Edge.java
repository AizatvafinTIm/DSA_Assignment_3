package com.company;

public class Edge<T> {
    T weight;
    T bandwidth;
    boolean isEmpty;

    Edge(){
        this.isEmpty = true;
    }

    Edge(T weight, T bandwidth){
        this.weight = weight;
        this.bandwidth = bandwidth;
    }

}
