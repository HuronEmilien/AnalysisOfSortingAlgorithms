package test.swing.generator;

import main.swing.generator.SecondHalfChunkGeneratorStrategy;
import main.swing.generator.GeneratorStrategy;

public class SecondHalfChunkGeneratorTest extends AbstractGeneratorTest {

    @Override
    protected GeneratorStrategy getGenerator() {
        return new SecondHalfChunkGeneratorStrategy(50);
    }

    @Override
    protected String getGeneratorName() {
        return "SecondHalfChunkGeneratorStrategy";
    }

    public static void main(String[] args) {
        new SecondHalfChunkGeneratorTest().runTests();
    }
}
