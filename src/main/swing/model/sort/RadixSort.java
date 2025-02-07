package main.swing.model.sort;

import main.swing.model.*;
import java.util.*;

/**
 * Implémentation de l'algorithme Radix Sort.
 */
public class RadixSort implements SortingStrategy {

    @Override
    public void sortingAlgorithm(SortingList sl) {
        int n = sl.getSize();
        int max = getMax(sl); // Trouver le plus grand nombre pour connaître le nombre de chiffres

        // Appliquer le tri pour chaque position de chiffre : unités, dizaines, centaines,
        int exp = 1;
        while (max / exp > 0) {
            countingSort(sl, n, exp);
            exp *= 10; // Passer à la position de chiffre suivante
        }
    }

    // Trouver le plus grand élément dans la liste.
    private int getMax(SortingList sl) {
        int max = sl.getElement(0);
        for (int i = 1; i < sl.getSize(); i++) {
            if (sl.getElement(i) > max) {
                max = sl.getElement(i);
            }
        }
        return max;
    }

    // Tri par comptage en fonction du chiffre à la position donnée
    private void countingSort(SortingList sl, int n, int exp) {
        int[] end = new int[n];
        int[] count = new int[10];

        // Compter les occurrences des chiffres à la position exp
        for (int i = 0; i < n; i++) {
            int digit = (sl.getElement(i) / exp) % 10;
            count[digit]++;
        }

        // Calculer les positions cumulées
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Construire le tableau de sortie trié
        for (int i = n - 1; i >= 0; i--) {
            int digit = (sl.getElement(i) / exp) % 10;
            end[count[digit] - 1] = sl.getElement(i);
            count[digit]--;
        }

        for (int i = 0; i < n; i++) {
            sl.set(i, end[i]);
        }
    }
}
