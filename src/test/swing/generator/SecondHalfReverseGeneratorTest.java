package test.swing.generator;

import main.swing.generator.SecondHalfReverseGeneratorStrategy;
import main.swing.generator.GeneratorStrategy;

public class SecondHalfReverseGeneratorTest extends AbstractGeneratorTest {

    @Override
    protected GeneratorStrategy getGenerator() {
        return new SecondHalfReverseGeneratorStrategy();
    }

    @Override
    protected String getGeneratorName() {
        return "SecondHalfReverseGeneratorStrategy";
    }

    public static void main(String[] args) {
        new SecondHalfReverseGeneratorTest().runTests();
    }
}
