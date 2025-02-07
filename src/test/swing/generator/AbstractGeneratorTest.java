package test.swing.generator;

import main.swing.generator.GeneratorStrategy;

import java.util.Arrays;
import java.util.Random;

public abstract class AbstractGeneratorTest {

    private static final int MAX_SIZE = 200;
    private boolean allTestsPassed = true;

    /**
     * Exécute les tests pour un générateur spécifique.
     */
    public void runTests() {
        System.out.println("==================================================");
        System.out.println("   Début des tests pour le générateur : " + getGeneratorName());
        System.out.println("==================================================");

        // Résumé des résultats
        boolean testPassed;

        // Tests classiques
        int[] testArray = generateRandomArray(MAX_SIZE);
        testPassed = testGenerator(testArray, "Tableau aléatoire");
        allTestsPassed &= testPassed;

        // Tests spécifiques
        testPassed = testWithSortedArray();
        allTestsPassed &= testPassed;

        testPassed = testWithDuplicates();
        allTestsPassed &= testPassed;

        testPassed = testWithNegativeValues();
        allTestsPassed &= testPassed;

        System.out.println("--------------------------------------------------");
        if (allTestsPassed) {
            System.out.println("✅ Tous les tests pour " + getGeneratorName() + " sont validés !");
        } else {
            System.out.println("❌ Certains tests pour " + getGeneratorName() + " ont échoué.");
        }
        System.out.println("==================================================\n");
    }

    /**
     * Méthode que les classes concrètes doivent implémenter pour fournir le générateur à tester.
     */
    protected abstract GeneratorStrategy getGenerator();

    /**
     * Méthode que les classes concrètes doivent implémenter pour fournir le nom du générateur.
     */
    protected abstract String getGeneratorName();

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

    /**
     * Teste un générateur avec un tableau donné.
     */
    private boolean testGenerator(int[] data, String description) {
        GeneratorStrategy generator = getGenerator();
        System.out.println("\n[Test : " + description + "]");
        System.out.println("Entrée : " + formatArray(data));

        int[] result = generator.generateSort(data);
        boolean passed = result.length == data.length;

        System.out.println("Sortie : " + formatArray(result));
        if (passed) {
            System.out.println("✅ Test validé pour : " + description);
        } else {
            System.out.println("❌ Échec du test pour : " + description);
        }

        return passed;
    }


    /**
     * Teste le générateur avec un tableau trié.
     */
    private boolean testWithSortedArray() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("Test avec un tableau trié");
        int[] sortedArray = new int[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++) {
            sortedArray[i] = i;
        }
        return testGenerator(sortedArray, "Tableau trié");
    }

    /**
     * Teste le générateur avec un tableau contenant des doublons.
     */
    private boolean testWithDuplicates() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("Test avec un tableau de doublons");
        int[] duplicateArray = new int[MAX_SIZE];
        Arrays.fill(duplicateArray, 5);
        return testGenerator(duplicateArray, "Tableau avec doublons");
    }

    /**
     * Teste le générateur avec des valeurs négatives.
     */
    private boolean testWithNegativeValues() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("Test avec un tableau de valeurs négatives");
        int[] negativeArray = generateRandomArray(MAX_SIZE);
        for (int i = 0; i < negativeArray.length; i++) {
            negativeArray[i] -= 500;
        }
        return testGenerator(negativeArray, "Tableau avec valeurs négatives");
    }

    public boolean runTestsAndReturnStatus() {
        runTests();
        return allTestsPassed;
    }

}
