package main.swing.model.sort;

import main.swing.model.*;

/**
 * Implémentation de la stratégie de tri Gnome Sort.
 */
public class GnomeSort implements SortingStrategy {

    @Override
    public void sortingAlgorithm(SortingList sl) {
        gnomeSort(sl);
    }

    // Méthode principale de tri Gnome Sort
    private void gnomeSort(SortingList sl) {
        int n = sl.getSize();
        int pos = 0;

        while (pos < n) {
            if (pos == 0 || sl.getElement(pos) >= sl.getElement(pos - 1)) {
                pos++; // Avancer si l'élément courant est à la bonne position
            } else {
                sl.swap(pos, pos - 1); // Échanger avec l'élément précédent
                pos--; // Reculer pour vérifier à nouveau
            }
        }
    }
}
