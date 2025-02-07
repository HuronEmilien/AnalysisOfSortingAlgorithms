package main.swing.generator;

public class SecondHalfReverseGeneratorStrategy implements GeneratorStrategy {

    @Override
    public int[] generateSort(int[] unsortedData) {
        int size = unsortedData.length;
        int[] temp = new int[size];
        
        for(int i = 0 ;i<size/2;i++){
            temp[i]=unsortedData[i];
        }
        
        for(int i = 0 ;i<size/2;i++){
            temp[i+size/2]=unsortedData[size-i-1];
        }
        return temp;
    }

    }
