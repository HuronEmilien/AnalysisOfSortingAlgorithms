package test.swing.generator;

import main.swing.generator.ReverseGeneratorStrategy;
import main.swing.generator.GeneratorStrategy;

public class ReverseGeneratorStrategyTest extends AbstractGeneratorTest {

    @Override
    protected GeneratorStrategy getGenerator() {
        return new ReverseGeneratorStrategy();
    }

    @Override
    protected String getGeneratorName() {
        return "ReverseGeneratorStrategy";
    }

    public static void main(String[] args) {
        new ReverseGeneratorStrategyTest().runTests();
    }
}
