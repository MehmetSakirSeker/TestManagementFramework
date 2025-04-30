import Composite.TestCase;
import Composite.TestComponent;
import Composite.TestSuite;

public class Main {
    public static void main(String[] args) {
        // Main testSuite
        TestComponent mainSuite = new TestSuite("Full Test Suite");

        // Leaf tests
        mainSuite.add(new TestCase("Login Test"));
        mainSuite.add(new TestCase("Payment Test"));

        // Composite testSuites
        TestComponent uiSuite = new TestSuite("UI Tests");
        uiSuite.add(new TestCase("UI Button Test"));
        uiSuite.add(new TestCase("UI Color Test"));

        mainSuite.add(uiSuite);

        // Try: invalid addition to the leaf
        TestComponent invalid = new TestCase("Invalid Case");
        invalid.add(new TestCase("Should Not Work"));
        mainSuite.add(invalid);
        mainSuite.remove(invalid);

        // Gösterim
        System.out.println("== Test Structure ==");
        mainSuite.display(1);

        // Testleri çalıştır
        System.out.println("\n== Tests are running now ==");
        mainSuite.execute();

    }
}