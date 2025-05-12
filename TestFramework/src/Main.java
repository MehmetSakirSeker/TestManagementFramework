import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Test components factory (Factory Method)
        TestCreator aixCreator = new AixTestCreator();
        ArrayList<TestComponent> aixTests = aixCreator.createTest();

        // Main test suite (Composite) that will contain all tests
        TestSuite allTests = new TestSuite("All Tests");

        System.out.println("=== Tests from the Factory Are Added to the Main Suite ===");
        for (TestComponent test : aixTests) {
            allTests.add(test);
            System.out.println("Added: " + test.getName());
        }
        System.out.println();

        // Single facade object to run tests (Singleton + Facade)
        FacadeAndSingleton testFacade = FacadeAndSingleton.getInstance(allTests);

        testFacade.runAllTests();         // Run all tests
        System.out.println("\n--- Only GUI Tests ---");
        testFacade.runGUITests();         // Run only GUI tests
        System.out.println("\n--- Only Network Tests ---");
        testFacade.runNetworkTests();     // Run only Network tests
    }
}
