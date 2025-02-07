package main.swing.model.sort;

import main.swing.model.*;

/**
 * Implémentation de l'algorithme Merge Sort.
 */
public class MergeSort implements SortingStrategy {

    @Override
    public void sortingAlgorithm(SortingList sl) {
        mergeSort(sl, 0, sl.getSize() - 1);
    }

    // Méthode récursive pour diviser le tableau en deux moitiés et les trier.
    private void mergeSort(SortingList sl, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(sl, left, mid);
            mergeSort(sl, mid + 1, right);
            merge(sl, left, mid, right);
        }
    }

    //Fusionne deux sous-listes triées en une seule liste triée.
    private void merge(SortingList sl, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Créer des tableaux temporaires pour stocker les sous-listes
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copier les données dans les tableaux temporaires
        for (int i = 0; i < n1; i++) {
            leftArray[i] = sl.getElement(left + i);
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = sl.getElement(mid + 1 + j);
        }

        // Fusionner les deux sous-listes en triant les éléments
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                sl.set(k, leftArray[i]);
                i++;
            } else {
                sl.set(k, rightArray[j]);
                j++;
            }
            k++;
        }

        // Copier les éléments restants de la sous-liste gauche
        while (i < n1) {
            sl.set(k, leftArray[i]);
            i++;
            k++;
        }

        // Copier les éléments restants de la sous-liste droite
        while (j < n2) {
            sl.set(k, rightArray[j]);
            j++;
            k++;
        }
    }
}
