package test.swing.model.sort;

import main.swing.model.sort.GnomeSort;
import main.swing.model.sort.SortingStrategy;

public class GnomeSortTest extends AbstractSortingTest {

    @Override
    protected SortingStrategy getSortingStrategy() {
        return new GnomeSort();
    }

    @Override
    protected String getSortName() {
        return "GnomeSort";
    }
}
