package main.swing.model.sort;

import main.swing.model.*;

/**
 * Implémentation de la stratégie de tri à bulles.
 */
public class BubbleSort implements SortingStrategy {
    
    @Override
    public void sortingAlgorithm(SortingList sl) {
        bubbleSort(sl);
    }

    // Méthode de tri à bulles
    public void bubbleSort(SortingList sl) {
        int n = sl.getSize();
        int temp;
        boolean swapped;
        int counter = 0;

        // Boucle principale qui passe sur la liste plusieurs fois
        for (int i = 0; i < n - 1; i++) {
            counter = i + 1;
            swapped = false;

            // Boucle interne pour comparer les éléments adjacents
            for (int j = 0; j < n - i - 1; j++) {

                // Si l'élément courant est plus grand que le suivant
                if (sl.getElement(j) > sl.getElement(j + 1)) {
                    // Échange des éléments
                    sl.swap(j, j + 1);
                    swapped = true;
                }
            }
            
            // Si aucun échange n'a eu lieu, la liste est déjà triée
            if (!swapped) {
                break;
            }
        }
    }
}
