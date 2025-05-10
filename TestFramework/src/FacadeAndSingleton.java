import Composite.TestComponent;
import Composite.TestSuite;
import Iterator.AbstractTestIterator;

public class FacadeAndSingleton {
    private static FacadeAndSingleton instance;
    private TestRunner testRunner;
    private TestSuite allTests;

    private FacadeAndSingleton(TestSuite allTests) {
        this.testRunner = new TestRunner();
        this.allTests = allTests;
    }

    public static synchronized FacadeAndSingleton getInstance(TestSuite allTests) {
        if (instance == null) {
            instance = new FacadeAndSingleton(allTests);
        }
        return instance;
    }

    public void runAllTests() {
        System.out.println("=== Facade: Tüm Testler Çalıştırılıyor ===");
        testRunner.runTestSuite(allTests);
    }

    public void runGUITests() {
        System.out.println("=== Facade: GUI Testleri Çalıştırılıyor ===");
        filterAndRunTests(allTests, "GUI");
    }

    public void runNetworkTests() {
        System.out.println("=== Facade: Network Testleri Çalıştırılıyor ===");
        filterAndRunTests(allTests, "Network");
    }

    public void runTestsByKeyword(String keyword) {
        System.out.println("=== Facade: '" + keyword + "' içeren Testler Çalıştırılıyor ===");
        filterAndRunTests(allTests, keyword);
    }

    protected void filterAndRunTests(TestSuite suite, String keyword) {
        AbstractTestIterator iterator = suite.createIterator();
        while (!iterator.isDone()) {
            TestComponent component = iterator.currentItem();
            if (component.getName().contains(keyword)) {
                if (component instanceof TestSuite) {
                    testRunner.runTestSuite((TestSuite) component);
                } else {
                    testRunner.runTest(component);
                }
            } else if (component instanceof TestSuite) {
                filterAndRunTests((TestSuite) component, keyword);
            }
            iterator.next();
        }
    }
}