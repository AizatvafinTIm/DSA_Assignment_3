package com.company;


import java.util.Scanner;


public class Main {
    static AdjacencyMatrixGraph<String,Integer> matrixGraph = new AdjacencyMatrixGraph<>();


    public static void main(String[] args) {

        for(int i = 0; i < 7;++i){
            Scanner in = new Scanner(System.in);
            String n = in.nextLine();
            input(n);
        }

    }
    public static void input(String n){

        String[] words = n.split(" ");
        switch (words[0]) {
            case  ("ADD_VERTEX"):
                matrixGraph.addVertex(words[1]);
                break;
            case ("ADD_EDGE"):
                int weight = Integer.parseInt(words[3]);
                Vertex<String> first = matrixGraph.findVertex(words[1]);
                Vertex<String> second = matrixGraph.findVertex(words[2]);
                matrixGraph.addEdge(first,second,weight,0);
                break;
            case ("HAS_EDGE"):

                boolean t = matrixGraph.hasEdge(matrixGraph.findVertex(words[1]),matrixGraph.findVertex(words[2]));
                if(t){
                    System.out.println("TRUE");
                }
                else {
                    System.out.println("FALSE");
                }
                break;
            case ("REMOVE_EDGE"):
                matrixGraph.removeEdge(matrixGraph.findEdge(words[1],words[2]));
                break;
            default:
                System.out.println("There is no such program");;
                break;
        }
    }
}
