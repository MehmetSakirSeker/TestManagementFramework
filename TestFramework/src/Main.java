import Composite.TestComponent;
import Composite.TestSuite;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        TestCreator aixCreator = new AixTestCreator();
        ArrayList<TestComponent> aixTests = aixCreator.createTest();
        TestSuite allTests = new TestSuite("Tüm Testler");
        System.out.println("=== Fabrikadan Gelen Testler Ana Suite'e Ekleniyor ===");
        for (TestComponent test : aixTests) {
            allTests.add(test);
            System.out.println("Eklenen: " + test.getName());
        }
        System.out.println();

        FacadeAndSingleton testFacade = FacadeAndSingleton.getInstance(allTests);

        testFacade.runAllTests();
        System.out.println("\n--- Sadece GUI Testleri ---");
        testFacade.runGUITests();
        System.out.println("\n--- Sadece Network Testleri ---");
        testFacade.runNetworkTests();

        System.out.println("\n--- 'Single' Kelimesini İçeren Testleri Çalıştır ---");
        testFacade.runTestsByKeyword("Single");

    }
}