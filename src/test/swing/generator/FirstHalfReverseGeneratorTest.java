package test.swing.generator;

import main.swing.generator.FirstHalfReverseGeneratorStrategy;
import main.swing.generator.GeneratorStrategy;

public class FirstHalfReverseGeneratorTest extends AbstractGeneratorTest {

    @Override
    protected GeneratorStrategy getGenerator() {
        return new FirstHalfReverseGeneratorStrategy();
    }

    @Override
    protected String getGeneratorName() {
        return "FirstHalfReverseGeneratorStrategy";
    }

    public static void main(String[] args) {
        new FirstHalfReverseGeneratorTest().runTests();
    }
}
