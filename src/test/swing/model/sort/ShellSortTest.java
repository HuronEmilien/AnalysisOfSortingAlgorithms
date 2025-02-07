package test.swing.model.sort;

import main.swing.model.sort.ShellSort;
import main.swing.model.sort.SortingStrategy;

public class ShellSortTest extends AbstractSortingTest {

    @Override
    protected SortingStrategy getSortingStrategy() {
        return new ShellSort();
    }

    @Override
    protected String getSortName() {
        return "ShellSort";
    }
}
