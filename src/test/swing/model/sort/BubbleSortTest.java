package test.swing.model.sort;

import main.swing.model.sort.BubbleSort;
import main.swing.model.sort.SortingStrategy;

public class BubbleSortTest extends AbstractSortingTest {

    @Override
    protected SortingStrategy getSortingStrategy() {
        return new BubbleSort();
    }

    @Override
    protected String getSortName() {
        return "BubbleSort";
    }
}
