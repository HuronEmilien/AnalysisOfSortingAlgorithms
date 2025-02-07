package test.swing.model.sort;

import main.swing.model.sort.HeapSort;
import main.swing.model.sort.SortingStrategy;

public class HeapSortTest extends AbstractSortingTest {

    @Override
    protected SortingStrategy getSortingStrategy() {
        return new HeapSort();
    }

    @Override
    protected String getSortName() {
        return "HeapSort";
    }
}
