package main.swing.generator;

import main.swing.model.sort.*;
import main.swing.model.*;
import main.swing.utils.*;

import java.io.*;

public class SortingResultJsonGenerator {

    public static final int[] SIZES = { 100000};
    public static final String BASE_DIR = "src/main/web/resources/data/json/";

    private GeneratorStrategy generator;
    private SortingStrategy[] sorts;
    private String generatorName;

    public SortingResultJsonGenerator(GeneratorStrategy generator, SortingStrategy[] sorts, String generatorName) {
        this.generator = generator;
        this.sorts = sorts;
        this.generatorName = generatorName;
    }

    public void executeTests() {
        String generatorDir = SortingResultJsonGenerator.BASE_DIR + this.generatorName;
        new File(generatorDir).mkdirs(); // Crée le dossier contenant tous les generateurs.

        for (int size : SortingResultJsonGenerator.SIZES) {

            String sizeDir = generatorDir + "/" + size;
            new File(sizeDir).mkdirs(); // Crée le dossier contenant toutes les tailles.
            int[] originalList = generateSortedList(size);

            for (int i = 0; i < this.sorts.length; i++) {

                String sortName = this.sorts[i].getClass().getSimpleName();

                // Applique le générateur et le tri
                int[] generatedList = this.generator.generateSort(originalList.clone());

                SortingList sortingList = new SortingList(this.sorts[i], sortName, originalList, generatedList);

                // Trie et mesure les performances
                sortingList.sort();
                this.saveResults(sizeDir, sortName, sortingList);
            }
        }
    }

    private int[] generateSortedList(int size) {
        int[] newList = new int[size];
        for (int i = 0; i < size; i++) {
            newList[i] = i + 1;
        }
        return newList;
    }

    private void saveResults(String sizeDir, String sortName, SortingList sortingList) {
        // Définit le chemin du fichier JSON
        String filePath = sizeDir + "/" + sortName + ".json";

        // Écrit les résultats dans un fichier JSON
        SortingDataWriter writer = new SortingDataWriter();
        writer.writeDataToJson(
                this.generatorName,
                sortName,
                sortingList.getSize(),
                sortingList.getComparisons(),
                sortingList.getArrayAccess(),
                sortingList.getSetOperations(),
                sortingList.getSwapOperations(),
                sortingList.getDelay(),
                sortingList.getPourcent()
        );
        System.out.println("Résultat enregistré : " + filePath);
    }

    public static void main(String[] args) {
        // Définir les stratégies de génération
        GeneratorStrategy[] generators = {
                new FirstHalfChunkGeneratorStrategy(100),
                new FirstHalfReverseGeneratorStrategy(),
                new RandomGeneratorStrategy(100),
                new ReverseGeneratorStrategy(),
                new SecondHalfChunkGeneratorStrategy(100),
                new SecondHalfReverseGeneratorStrategy()
        };


        // Définir les algorithmes de tri
        SortingStrategy[] sorts = {
                new BubbleSort(),
                new CocktailShakerSort(),
                new GnomeSort(),
                new HeapSort(),
                new InsertionSort(),
                new MergeSort(),
                new QuickSort(),
                new RadixSort(),
                new SelectionSort(),
                new ShellSort()
        };

        // Effectuer les tests
        for (int i = 0; i < generators.length; i++) {
            SortingResultJsonGenerator demo = new SortingResultJsonGenerator(generators[i], sorts, generators[i].getClass().getSimpleName());
            demo.executeTests();
        }
    }

}
