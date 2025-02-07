package test.swing.model.sort;

import main.swing.model.sort.TimSort;
import main.swing.model.sort.SortingStrategy;

public class TimSortTest extends AbstractSortingTest {

    @Override
    protected SortingStrategy getSortingStrategy() {
        return new TimSort();
    }

    @Override
    protected String getSortName() {
        return "TimSort";
    }
}