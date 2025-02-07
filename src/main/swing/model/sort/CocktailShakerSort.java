package main.swing.model.sort;

import main.swing.model.*;

/**
 * Implémentation de la stratégie de tri Cocktail Shaker Sort.
 */
public class CocktailShakerSort implements SortingStrategy {

    @Override
    public void sortingAlgorithm(SortingList sl) {
        cocktailShakerSort(sl);
    }

    // Méthode principale de tri cocktailShaker
    private void cocktailShakerSort(SortingList sl) {
        int n = sl.getSize();
        boolean echange = true;
        int start = 0;
        int end = n - 1;

        while (echange) {
            echange = false;

            // Parcours de gauche à droite
            for (int i = start; i < end; i++) {
                if (sl.getElement(i) > sl.getElement(i + 1)) {
                    sl.swap(i, i + 1); // Échanger les éléments
                    echange = true;
                }
            }

            // Réduire la plage de tri
            end--;

            if (!echange) {
                break; // Si aucun échange n'a eu lieu, la liste est triée
            }

            echange = false;

            // Parcours de droite à gauche
            for (int i = end; i > start; i--) {
                if (sl.getElement(i) < sl.getElement(i - 1)) {
                    sl.swap(i, i - 1); // Échanger les éléments
                    echange = true;
                }
            }

            // Réduire la plage de tri
            start++;
        }
    }
}
