package test.swing.model.sort;

import main.swing.model.sort.InsertionSort;
import main.swing.model.sort.SortingStrategy;

public class InsertionSortTest extends AbstractSortingTest {

    @Override
    protected SortingStrategy getSortingStrategy() {
        return new InsertionSort();
    }

    @Override
    protected String getSortName() {
        return "InsertionSort";
    }
}
