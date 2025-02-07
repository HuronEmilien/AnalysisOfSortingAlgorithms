package main.swing.generator;

public class SecondHalfChunkGeneratorStrategy implements GeneratorStrategy {

    private int n;

    public SecondHalfChunkGeneratorStrategy(int n) {
        this.n = n;
    }

    @Override
    public int[] generateSort(int[] unsortedData) {
        int halfSize = unsortedData.length / 2;
        int[] secondHalf = new int[halfSize];
        System.arraycopy(unsortedData, halfSize, secondHalf, 0, halfSize);

        RandomGeneratorStrategy randomGenerator = new RandomGeneratorStrategy(n);
        int[] randomSecondHalf = randomGenerator.generateSort(secondHalf);

        int[] sortedData = new int[unsortedData.length];
        System.arraycopy(unsortedData, 0, sortedData, 0, halfSize);
        System.arraycopy(randomSecondHalf, 0, sortedData, halfSize, halfSize);

        return sortedData;
    }
}