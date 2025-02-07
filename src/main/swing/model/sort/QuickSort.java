package main.swing.model.sort;

import main.swing.model.*;
import java.util.*;

/**
 * Optimized Iterative QuickSort implementation
 */
public class QuickSort implements SortingStrategy {
    private static final int INSERTION_SORT_THRESHOLD = 10;

    @Override
    public void sortingAlgorithm(SortingList sl) {
        iterativeQuickSort(sl, 0, sl.getSize() - 1);
    }

    private void iterativeQuickSort(SortingList sl, int low, int high) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{low, high});

        while (!stack.isEmpty()) {
            int[] range = stack.pop();
            low = range[0];
            high = range[1];

            // Use insertion sort for small subarrays
            if (high - low < INSERTION_SORT_THRESHOLD) {
                insertionSort(sl, low, high);
                continue;
            }

            if (low < high) {
                int pivotIndex = partition(sl, low, high);
                stack.push(new int[]{low, pivotIndex - 1});
                stack.push(new int[]{pivotIndex + 1, high});
            }
        }
    }

    private int selectPivot(SortingList sl, int low, int high) {
        // Median-of-three pivot selection
        int mid = low + (high - low) / 2;
        if (sl.getElement(mid) < sl.getElement(low))
            sl.swap(low, mid);
        if (sl.getElement(high) < sl.getElement(low))
            sl.swap(low, high);
        if (sl.getElement(mid) < sl.getElement(high))
            sl.swap(mid, high);
        return high; // pivot is now at high
    }

    private int partition(SortingList sl, int low, int high) {
        int pivotIndex = selectPivot(sl, low, high);
        int pivot = sl.getElement(pivotIndex);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (sl.getElement(j) <= pivot) {
                i++;
                sl.swap(i, j);
            }
        }

        sl.swap(i + 1, high);
        return i + 1;
    }

    private void insertionSort(SortingList sl, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = sl.getElement(i);
            int j = i - 1;
            while (j >= low && sl.getElement(j) > key) {
                sl.swap(j + 1, j);
                j--;
            }
        }
    }
}