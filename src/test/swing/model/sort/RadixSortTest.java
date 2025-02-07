package test.swing.model.sort;

import main.swing.model.sort.RadixSort;
import main.swing.model.sort.SortingStrategy;

public class RadixSortTest extends AbstractSortingTest {

    @Override
    protected SortingStrategy getSortingStrategy() {
        return new RadixSort();
    }

    @Override
    protected String getSortName() {
        return "RadixSort";
    }
}
