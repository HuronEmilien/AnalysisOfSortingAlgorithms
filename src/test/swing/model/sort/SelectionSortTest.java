package test.swing.model.sort;

import main.swing.model.sort.SelectionSort;
import main.swing.model.sort.SortingStrategy;

public class SelectionSortTest extends AbstractSortingTest {

    @Override
    protected SortingStrategy getSortingStrategy() {
        return new SelectionSort();
    }

    @Override
    protected String getSortName() {
        return "SelectionSort";
    }
}
