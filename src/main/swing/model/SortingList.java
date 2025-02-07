package main.swing.model;

import java.util.*;

import main.swing.model.sort.*;
import main.swing.utils.*;

/**
 *
 *
 * @author Florian Pépin
 * @version 1.0
 */
public class SortingList extends AbstractListenableModel {

    private SortingStrategy sortingStrategy;
    private int[] data; //data triées avant la modification par le générateur.
    private int[] generatorData; //data du générateur
    private final int[] originalData; // sauvegarde des data du générateur.
    private int size;
    private int current1;
    private int current2;
    private long delay;
    private int comparisons;
    private int arrayAccess;
    private String sortName;
    private long startTime;

    private int setOperations;
    private int swapOperations;
    private final Set<Integer> correctIndices;
    private final List<Sextet<Integer, Integer, Integer, Integer, Integer, Long>> correctPositions;

    public SortingList(SortingStrategy sortingStrategy, String sortName, int[] data, int[] generatorData) {
        super();
        this.sortingStrategy = sortingStrategy;
        this.data = data;
        this.generatorData = generatorData;
        this.originalData = Arrays.copyOf(generatorData, generatorData.length);
        this.size = this.data.length;
        this.current1 = -1;
        this.current2 = -1;
        this.delay = 0;
        this.comparisons = 0;
        this.arrayAccess = 0;
        this.sortName = sortName;
        this.startTime = 0;

        this.setOperations = 0;
        this.swapOperations = 0;
        this.correctIndices = new HashSet<>();
        this.correctPositions = new ArrayList<>();



    }

    public int[] getData() {
        return this.data;
    }

    public int[] getGeneratorData() {
        return this.generatorData;
    }

    public int[] getOriginalData() {
        return this.originalData;
    }

    public Integer getElement(int i) {
        this.comparisons++;
        this.arrayAccess++;
        return this.generatorData[i];
    }

    public int getCurrent1() {
        return current1;
    }

    public int getCurrent2() {
        return current2;
    }

    public int getSetOperations() {
        return this.setOperations;
    }

    public int getSwapOperations() {
        return this.swapOperations;
    }

    public long getDelay() {
        return this.delay;
    }

    public int getComparisons() {
        return this.comparisons;
    }

    public int getArrayAccess() {
        return this.arrayAccess;
    }

    public String getSortName() {
        return this.sortName;
    }

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.fireChange("step");
        this.sortingStrategy = sortingStrategy;
    }

    public SortingStrategy getSortingStrategy() {
        return this.sortingStrategy;
    }

    public void setCurrent1(int current1) {
        this.fireChange("step");
        this.current1 = current1;
    }

    public void setCurrent2(int current2) {
        this.fireChange("step");
        this.current2 = current2;
    }

    public int getSize() {
        return this.size;
    }

    public void set(int i, int value) {


        this.generatorData[i] = value;
        this.arrayAccess++;
        this.setOperations++;
        this.setCurrent2(i);

        if (this.data[i] == value) {
            correctIndices.add(i);
        }


        this.recordStatistics();
        this.fireChange("step");
    }

    public void swap(int i, int j) {
        if (i != j) {
            int tmp = this.generatorData[i];
            this.generatorData[i] = this.generatorData[j];
            this.generatorData[j] = tmp;
            this.arrayAccess += 2;
            this.swapOperations++;
            this.setCurrent1(i);
            this.setCurrent2(j);

            if (this.generatorData[i] == this.data[i]) {
                correctIndices.add(i);
            }
            if (this.generatorData[j] == this.data[j]) {
                correctIndices.add(j);
            }
            this.recordStatistics();
            this.fireChange("step");
        }
    }

    public void recordStatistics() {
        this.correctPositions.add(new Sextet(
                correctIndices.size(),
                this.setOperations,
                this.swapOperations,
                this.arrayAccess,
                this.comparisons,
                this.getActualDelay()
        ));
    }

    public long getActualDelay(){
        return (System.currentTimeMillis() - this.startTime);
    }

    public void sort() {
        this.resetData();
        this.startTime = System.currentTimeMillis();
        this.sortingStrategy.sortingAlgorithm(this);
        long endTime = System.currentTimeMillis();
        this.delay = (endTime - this.startTime);
        this.fireChange("end");
        this.startTime = 0;
    }

    public void resetData() {
        this.setOperations = 0;
        this.swapOperations = 0;
        this.correctIndices.clear();
        this.correctPositions.clear();
        this.generatorData = Arrays.copyOf(this.originalData, this.originalData.length);
    }

    public boolean isSorted() {
        for (int i = 0; i < this.generatorData.length - 1; i++) {
            if (this.generatorData[i] > this.generatorData[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public void reload() {
        this.generatorData = Arrays.copyOf(this.originalData, this.originalData.length);
        this.delay = 0;
        this.comparisons = 0;
        this.arrayAccess = 0;
        this.fireChange("step");
    }

    public void reload(SortingStrategy sortingStrategy, String sortName) {
        this.sortingStrategy = sortingStrategy;
        this.sortName = sortName;
        this.reload();
    }

    public int[][] getPourcent() {
        int[][] evolutionPoints = new int[10][6];
        for (int i = 0; i < 10; i++) {
            int index = (i + 1) * (correctPositions.size() / 10) - 1;
            if (index < correctPositions.size() && index >= 0) {
                Sextet<Integer, Integer, Integer, Integer, Integer, Long> t = correctPositions.get(index);
                evolutionPoints[i][0] = t.getFirst();
                evolutionPoints[i][1] = t.getSecond();
                evolutionPoints[i][2] = t.getThird();
                evolutionPoints[i][3] = t.getFourth();
                evolutionPoints[i][4] = t.getFifth();
                evolutionPoints[i][5] = ((int)t.getSixth().longValue());
            }
        }
        return evolutionPoints;
    }

    public void printEvolutionStatistics(int[][] evolutionPoints) {
        System.out.println("Evolution statistics : ");
        for (int i = 0; i < 10; i++) {
            System.out.println("Step " + (i + 1) + " : " + evolutionPoints[i][0] + " correct elements, " + evolutionPoints[i][1] + " set operations, " + evolutionPoints[i][2] + " swap operations, " + evolutionPoints[i][3] + " array accesses, " + evolutionPoints[i][4] + " comparisons");
        }
    }
}
