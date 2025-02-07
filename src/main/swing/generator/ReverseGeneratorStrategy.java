package main.swing.generator;

public class ReverseGeneratorStrategy implements GeneratorStrategy {

    @Override
    public int[] generateSort(int[] unsortedData) {
        int size = unsortedData.length;
        int[] temp = new int[size];
        for(int i = 0 ;i<size;i++){
            temp[i]=unsortedData[size-i-1];
        }
        return temp;
    }

    }