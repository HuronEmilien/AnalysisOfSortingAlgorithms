package test.swing.generator;

public class AllGeneratorsTest {

    public static void main(String[] args) {
        boolean allTestsPassed = runTestsAndReturnStatus();
        
        System.out.println("==================================================");
        if (allTestsPassed) {
            System.out.println("🎉 Tous les tests pour tous les générateurs sont validés avec succès !");
        } else {
            System.out.println("❌ Certains tests ont échoué. Veuillez vérifier les détails ci-dessus.");
        }
        System.out.println("==================================================");
    }

    // 🚀 Nouvelle méthode pour permettre l'appel depuis AllTestsLauncher
    public static boolean runTestsAndReturnStatus() {
        System.out.println("==================================================");
        System.out.println("          Lancement de tous les tests            ");
        System.out.println("==================================================");

        boolean allTestsPassed = true;

        allTestsPassed &= new FirstHalfChunkGeneratorTest().runTestsAndReturnStatus();
        allTestsPassed &= new FirstHalfReverseGeneratorTest().runTestsAndReturnStatus();
        allTestsPassed &= new RandomGeneratorStrategyTest().runTestsAndReturnStatus();
        allTestsPassed &= new ReverseGeneratorStrategyTest().runTestsAndReturnStatus();
        allTestsPassed &= new SecondHalfChunkGeneratorTest().runTestsAndReturnStatus();
        allTestsPassed &= new SecondHalfReverseGeneratorTest().runTestsAndReturnStatus();

        return allTestsPassed;
    }
}
