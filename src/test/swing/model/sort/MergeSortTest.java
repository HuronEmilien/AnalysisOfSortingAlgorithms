package test.swing.model.sort;

import main.swing.model.sort.MergeSort;
import main.swing.model.sort.SortingStrategy;

public class MergeSortTest extends AbstractSortingTest {

    @Override
    protected SortingStrategy getSortingStrategy() {
        return new MergeSort();
    }

    @Override
    protected String getSortName() {
        return "MergeSort";
    }
}
