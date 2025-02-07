package test.swing.generator;

import main.swing.generator.FirstHalfChunkGeneratorStrategy;
import main.swing.generator.GeneratorStrategy;

public class FirstHalfChunkGeneratorTest extends AbstractGeneratorTest {

    @Override
    protected GeneratorStrategy getGenerator() {
        return new FirstHalfChunkGeneratorStrategy(50);
    }

    @Override
    protected String getGeneratorName() {
        return "FirstHalfChunkGeneratorStrategy";
    }

    public static void main(String[] args) {
        new FirstHalfChunkGeneratorTest().runTests();
    }
}
