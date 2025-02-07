package test.swing.model.sort;

import main.swing.model.sort.CocktailShakerSort;
import main.swing.model.sort.SortingStrategy;

public class CocktailShakerSortTest extends AbstractSortingTest {

    @Override
    protected SortingStrategy getSortingStrategy() {
        return new CocktailShakerSort();
    }

    @Override
    protected String getSortName() {
        return "CocktailShakerSort";
    }
}
