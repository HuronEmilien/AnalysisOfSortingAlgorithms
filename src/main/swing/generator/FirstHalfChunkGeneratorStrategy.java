package main.swing.generator;

public class FirstHalfChunkGeneratorStrategy implements GeneratorStrategy {

    private int n;

    public FirstHalfChunkGeneratorStrategy(int n) {
        this.n = n;
    }

    @Override
    public int[] generateSort(int[] unsortedData) {
        int halfSize = unsortedData.length / 2;
        int[] firstHalf = new int[halfSize];
        System.arraycopy(unsortedData, 0, firstHalf, 0, halfSize);

        RandomGeneratorStrategy randomGenerator = new RandomGeneratorStrategy(n);
        int[] randomFirstHalf = randomGenerator.generateSort(firstHalf);

        int[] sortedData = new int[unsortedData.length];
        System.arraycopy(randomFirstHalf, 0, sortedData, 0, halfSize);
        System.arraycopy(unsortedData, halfSize, sortedData, halfSize, unsortedData.length - halfSize);

        return sortedData;
    }
}