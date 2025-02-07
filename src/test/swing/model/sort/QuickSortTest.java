package test.swing.model.sort;

import main.swing.model.sort.QuickSort;
import main.swing.model.sort.SortingStrategy;

public class QuickSortTest extends AbstractSortingTest {

    @Override
    protected SortingStrategy getSortingStrategy() {
        return new QuickSort();
    }

    @Override
    protected String getSortName() {
        return "QuickSort";
    }
}
