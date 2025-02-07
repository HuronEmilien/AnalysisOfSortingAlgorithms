package main.swing.generator;

import java.util.*;

public class Demo {

    public static int[] generateRandomList(int n) {
        int[] newList = new int[n];
        for(int i = 0; i < n; i++) {
            newList[i] = i;
        }
        return newList;
    }

    public static int calcEntropy(int[] randomList, int[] unsortedData) {
        if (randomList.length != unsortedData.length) {
            throw new IllegalArgumentException("Les tableaux pas de la meme taille !");
        }

        int cmp = 0;
        for (int i = 0; i < randomList.length; i++) {
            if(randomList[i] != unsortedData[i]) {
                cmp++;
            }
        }
        return (cmp * 100) / randomList.length;
    }

    public static void main(String[] args) {


        System.out.println("=============Trie aleatoire================");
        int[] randomList = Demo.generateRandomList(1000);
        System.out.println("Liste non triée: "+ Arrays.toString(randomList));
        GeneratorStrategy g = new RandomGeneratorStrategy(100);
        int[] unsortedData = g.generateSort(randomList);
        System.out.println("Liste aléatoire: "+ Arrays.toString(unsortedData));
        System.out.println("Niveau d'entropie : "+ Demo.calcEntropy(randomList, unsortedData) + "%");

        System.out.println("=============Trie First half aleatoire================");
        System.out.println("Liste non triée : "+ Arrays.toString(randomList));
        GeneratorStrategy h = new FirstHalfChunkGeneratorStrategy(100);
        int[] randomList1 = h.generateSort(randomList);
        System.out.println("Liste aléatoire : "+ Arrays.toString(randomList1));
        System.out.println("Niveau d'entropie : "+ Demo.calcEntropy(randomList, randomList1) + "%");


        System.out.println("=============Trie Second half aleatoire================");
        System.out.println("Liste non triée : "+ Arrays.toString(randomList));
        GeneratorStrategy h1 = new SecondHalfChunkGeneratorStrategy(100);
        int[] randomList2 = h1.generateSort(randomList);
        System.out.println("Liste aléatoire : "+ Arrays.toString(randomList2));
        System.out.println("Niveau d'entropie : "+ Demo.calcEntropy(randomList, randomList2) + "%");



        int[] unsortedData3 = Demo.generateRandomList(20);


        System.out.println("=============Trie Reverse================");
        System.out.println("Liste non triée : "+ Arrays.toString(unsortedData3));
        ReverseGeneratorStrategy r = new ReverseGeneratorStrategy();
        int[] randomList3 = r.generateSort(unsortedData3);
        System.out.println("Liste aléatoire : "+ Arrays.toString(randomList3));
        System.out.println("Niveau d'entropie : "+ Demo.calcEntropy(unsortedData3, randomList3) + "%");



        System.out.println("=============Trie First Half Reverse================");
        System.out.println("Liste non triée : "+ Arrays.toString(unsortedData3));
        FirstHalfReverseGeneratorStrategy fhr = new FirstHalfReverseGeneratorStrategy();
        int[] randomList4 = fhr.generateSort(unsortedData3);
        System.out.println("Liste aléatoire : "+ Arrays.toString(randomList4));
        System.out.println("Niveau d'entropie : "+ Demo.calcEntropy(unsortedData3, randomList4) + "%");


        System.out.println("=============Trie Second Half Reverse================");
        System.out.println("Liste non triée : "+ Arrays.toString(unsortedData3));
        SecondHalfReverseGeneratorStrategy fhr2 = new SecondHalfReverseGeneratorStrategy();
        int[] randomList5 = fhr2.generateSort(unsortedData3);
        System.out.println("Liste aléatoire : "+ Arrays.toString(randomList5));
        System.out.println("Niveau d'entropie : "+ Demo.calcEntropy(unsortedData3, randomList5) + "%");
        
    }
}