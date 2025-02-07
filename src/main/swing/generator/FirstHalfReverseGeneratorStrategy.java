package main.swing.generator;

public class FirstHalfReverseGeneratorStrategy implements GeneratorStrategy {

    @Override
    public int[] generateSort(int[] unsortedData) {
        int size = unsortedData.length;
        int[] temp = new int[size];
        for(int i = 0 ;i<size/2;i++){
            temp[i]=unsortedData[size/2-i-1];
        }
        for(int i = size/2 ;i<size;i++){
            temp[i]=unsortedData[i];
        }
        return temp;
    }

    }
