package test.swing.generator;

import main.swing.generator.RandomGeneratorStrategy;
import main.swing.generator.GeneratorStrategy;

public class RandomGeneratorStrategyTest extends AbstractGeneratorTest {

    @Override
    protected GeneratorStrategy getGenerator() {
        return new RandomGeneratorStrategy(30);
    }

    @Override
    protected String getGeneratorName() {
        return "RandomGeneratorStrategy";
    }

    public static void main(String[] args) {
        new RandomGeneratorStrategyTest().runTests();
    }
}
