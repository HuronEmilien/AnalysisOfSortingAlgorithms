package main.swing;

import main.swing.generator.*;
import main.swing.model.*;
import main.swing.model.sort.*;
import main.swing.view.*;

import java.util.Arrays;

/**
 *
 * @author Florian Pépin
 * @version 1.0
 */
public class Main {

    /**
     * Crée une liste de taille n.
     *
     * @param n taille de la liste.
     * @return la liste de taille n.
     */
    public static int[] createList(int n) {
        int[] newList = new int[n];
        for(int i=1; i<=n; i++) {
            newList[i-1] = i;
        }
        return newList;
    }

    public static void main(String[] args) {
        SortingStrategy strat = new QuickSort();
        int[] data = Main.createList(100);
        GeneratorStrategy rgs = new RandomGeneratorStrategy(75); //pourcentage de trie de la liste.

        SortingList sl = new SortingList(strat, "Quick", data, rgs.generateSort(data));
        GUI g = new GUI(sl);
    }
    
}
