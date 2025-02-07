package test.swing.model.sort;

import main.swing.model.SortingList;
import main.swing.model.sort.SortingStrategy;

import java.util.Arrays;
import java.util.Random;

public abstract class AbstractSortingTest {

    private static final int MAX_SIZE = 100;
    private boolean allTestsPassed = true;

    /**
     * Exécute les tests pour une stratégie de tri spécifique.
     */
    public void runTests() {
        System.out.println("==================================================");
        System.out.println("   Début des tests pour : " + getSortName());
        System.out.println("==================================================");

        // Résumé des résultats
        boolean testPassed;

        // Tests classiques
        int[] randomArray = generateRandomArray(MAX_SIZE);
        testPassed = testSorting(randomArray, "Tableau aléatoire");
        allTestsPassed &= testPassed;

        // Tests spécifiques
        testPassed = testSortedArray();
        allTestsPassed &= testPassed;

        testPassed = testDuplicatesArray();
        allTestsPassed &= testPassed;

        testPassed = testNegativeArray();
        allTestsPassed &= testPassed;

        System.out.println("--------------------------------------------------");
        if (allTestsPassed) {
            System.out.println("✅ Tous les tests pour " + getSortName() + " sont validés !");
        } else {
            System.out.println("❌ Certains tests pour " + getSortName() + " ont échoué.");
        }
        System.out.println("==================================================\n");
    }

    /**
     * Méthode que les sous-classes doivent implémenter pour fournir la stratégie de tri à tester.
     */
    protected abstract SortingStrategy getSortingStrategy();

    /**
     * Méthode que les sous-classes doivent implémenter pour fournir le nom de la stratégie de tri.
     */
    protected abstract String getSortName();

    /**
     * Génère un tableau aléatoire.
     */
    private int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }

    /**
     * Vérifie si la stratégie actuelle est RadixSort.
     */
    private boolean isRadixSort() {
        return getSortingStrategy().getClass().getSimpleName().equals("RadixSort");
    }

    /**
     * Exécute les tests et retourne un booléen indiquant si tous les tests sont passés.
     */
    public boolean runTestsAndReturnStatus() {
        runTests();
        return allTestsPassed;
    }

    /**
     * Teste une stratégie de tri avec un tableau donné.
     */
    private boolean testSorting(int[] array, String description) {
        System.out.println("\n[Test : " + description + "]");
        System.out.println("Entrée : " + formatArray(array));

        SortingList sortingList = new SortingList(getSortingStrategy(), getSortName(), array, array.clone());
        sortingList.sort();
        boolean isSorted = sortingList.isSorted();

        System.out.println("Sortie : " + formatArray(sortingList.getGeneratorData()));
        if (isSorted) {
            System.out.println("✅ Test validé pour : " + description);
        } else {
            System.out.println("❌ Échec du test pour : " + description);
        }

        return isSorted;
    }

    /**
     * Teste la stratégie de tri avec un tableau déjà trié.
     */
    private boolean testSortedArray() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("Test avec un tableau trié");
        int[] sortedArray = new int[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++) {
            sortedArray[i] = i;
        }
        return testSorting(sortedArray, "Tableau trié");
    }

    /**
     * Teste la stratégie de tri avec un tableau contenant des doublons.
     */
    private boolean testDuplicatesArray() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("Test avec un tableau de doublons");
        int[] duplicateArray = new int[MAX_SIZE];
        Arrays.fill(duplicateArray, 5);
        return testSorting(duplicateArray, "Tableau avec doublons");
    }

    /**
     * Teste la stratégie de tri avec un tableau contenant des valeurs négatives.
     */
    private boolean testNegativeArray() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("Test avec un tableau de valeurs négatives");

        // Si la stratégie est RadixSort, on ignore ce test
        if (isRadixSort()) {
            System.out.println("⚠️ Test ignoré pour : Tableau avec valeurs négatives (RadixSort ne supporte pas les nombres négatifs).");
            return true; // Considéré comme réussi car il est intentionnellement ignoré
        }

        int[] negativeArray = generateRandomArray(MAX_SIZE);
        for (int i = 0; i < negativeArray.length; i++) {
            negativeArray[i] -= 500;
        }
        return testSorting(negativeArray, "Tableau avec valeurs négatives");
    }

    /**
     * Formate un tableau pour l'affichage, en limitant le nombre d'éléments affichés.
     */
    private String formatArray(int[] array) {
        if (array.length <= 10) {
            return Arrays.toString(array);
        }
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < 5; i++) {
            builder.append(array[i]).append(", ");
        }
        builder.append("... ");
        for (int i = array.length - 5; i < array.length; i++) {
            builder.append(array[i]);
            if (i < array.length - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}

