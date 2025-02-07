package test.swing;

import test.swing.model.sort.AllSortsTest;
import test.swing.generator.AllGeneratorsTest;

public class AllTestsLauncher {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("         Lancement de tous les tests du projet    ");
        System.out.println("==================================================");

        boolean allTestsPassed = true;

        // Lancer les tests des générateurs
        System.out.println("\n▶ Lancement des tests des générateurs...");
        boolean generatorsPassed = AllGeneratorsTest.runTestsAndReturnStatus();
        allTestsPassed &= generatorsPassed;

        // Lancer les tests des tris
        System.out.println("\n▶ Lancement des tests des tris...");
        boolean sortsPassed = AllSortsTest.runTestsAndReturnStatus();
        allTestsPassed &= sortsPassed;

        System.out.println("\n==================================================");
        if (allTestsPassed) {
            System.out.println("🎉 TOUS LES TESTS ONT RÉUSSI AVEC SUCCÈS ! ✅");
        } else {
            System.out.println("❌ Certains tests ont échoué. Veuillez vérifier les détails ci-dessus.");
        }
        System.out.println("==================================================");
    }
}
