package main.swing.model.sort;

import main.swing.model.*;

/**
 * Implémentation de l'algorithme HeapSort.
 */
public class HeapSort implements SortingStrategy {

    @Override
    public void sortingAlgorithm(SortingList sl) {
        int n = sl.getSize();

        // Construire un tas max
        buildMaxHeap(sl, n);

        // Extraire les éléments un par un du tas
        for (int i = n - 1; i > 0; i--) {
            sl.swap(0, i); // Échanger le maximum avec le dernier élément
            heapify(sl, i, 0); // Réparer le tas pour les éléments restants
        }
    }

    // Méthode pour construire un tas max
    private void buildMaxHeap(SortingList sl, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(sl, n, i); // Appliquer heapify sur chaque sous-arbre
        }
    }

    // Méthode pour réparer un sous-arbre afin qu'il respecte la propriété de tas max
    private void heapify(SortingList sl, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Vérifier si le fils gauche existe et est plus grand que la racine
        if (left < n && sl.getElement(left) > sl.getElement(largest)) {
            largest = left;
        }

        // Vérifier si le fils droit existe et est plus grand que le plus grand élément actuel
        if (right < n && sl.getElement(right) > sl.getElement(largest)) {
            largest = right;
        }

        // Si le plus grand élément n'est pas la racine, on échange
        if (largest != i) {
            sl.swap(i, largest);
            heapify(sl, n, largest);
        }
    }
}
