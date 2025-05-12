// FacadeAndSingleton Class
// ------------------------
// This class combines two design patterns:
// 1. Singleton: Only one instance of this class can be created.
//    Use getInstance() to get or create the instance.
// 2. Facade: Provides simple methods to run different types of tests,
//    so the user does not need to know complex details.

// It uses a TestRunner to run tests and a TestSuite that contains all tests.
public class FacadeAndSingleton {
    private static FacadeAndSingleton instance;  // The one and only instance (Singleton)
    private TestRunner testRunner;               // Helps to run tests
    private TestSuite allTests;                  // Contains all tests

    // Private constructor to prevent direct creation of the object
    private FacadeAndSingleton(TestSuite allTests) {
        this.testRunner = new TestRunner();
        this.allTests = allTests;
    }

    // Singleton method: returns the single instance (creates it if needed)
    public static FacadeAndSingleton getInstance(TestSuite allTests) {
        if (instance == null) {
            instance = new FacadeAndSingleton(allTests);
        }
        return instance;
    }

    // Facade method: runs all tests
    protected void runAllTests() {
        System.out.println("=== Facade: All Tests Are Running ===");
        testRunner.runTestSuite(allTests);
    }

    // Facade method: runs only GUI-related tests
    protected void runGUITests() {
        System.out.println("=== Facade: GUI Tests Are Running ===");
        filterAndRunTests(allTests, "GUI");
    }

    // Facade method: runs only Network-related tests
    protected void runNetworkTests() {
        System.out.println("=== Facade: Network Tests Are Running ===");
        filterAndRunTests(allTests, "Network");
    }

    // Helper method: filters tests by keyword and runs them
    protected void filterAndRunTests(TestSuite suite, String keyword) {
        BaseTestCommand command = new BaseTestCommand(suite, testRunner) {
            @Override
            public void execute() {
                // Anonymous command object with custom logic
            }
        };
        command.filterAndRunTests(suite, keyword);
    }
}
