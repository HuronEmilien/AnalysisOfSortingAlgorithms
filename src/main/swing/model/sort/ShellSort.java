package main.swing.model.sort;

import main.swing.model.*;

/**
 * Implémentation de l'algorithme Shell Sort.
 */
public class ShellSort implements SortingStrategy {

    @Override
    public void sortingAlgorithm(SortingList sl) {
        int n = sl.getSize();

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = sl.getElement(i);
                int j = i;
                while (j >= gap && sl.getElement(j - gap) > temp) {
                    sl.set(j, sl.getElement(j - gap));
                    j -= gap;
                }
                sl.set(j, temp);
            }
        }
    }
}
