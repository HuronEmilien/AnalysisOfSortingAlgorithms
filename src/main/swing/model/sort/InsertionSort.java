package main.swing.model.sort;

import main.swing.model.*;

/**
 * Implémentation de l'algorithme Insertion Sort.
 */
public class InsertionSort implements SortingStrategy {

    @Override
    public void sortingAlgorithm(SortingList sl) {
        int n = sl.getSize();
        for (int i = 1; i < n; i++) {
            int k = sl.getElement(i);
            int j = i - 1;
            while (j >= 0 && sl.getElement(j) > k) {
                sl.set(j + 1, sl.getElement(j)); 
                j--;
            }
            sl.set(j + 1, k);
        }
    }
}
