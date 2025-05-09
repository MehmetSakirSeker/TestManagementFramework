import Composite.TestComponent;
import Composite.TestSuite;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
            TestCreator aixCreator = new MacTestCreator();

            ArrayList<TestComponent> aixTests = aixCreator.createTest();
            TestSuite allTests = new TestSuite("Tüm Testler");

            System.out.println("=== Testler Ana Suite'e Ekleniyor ===");
            for (TestComponent test : aixTests) {
                allTests.add(test);
                System.out.println("Eklenen: " + test.getName());
            }
            System.out.println();

            TestRunner testRunner = new TestRunner();
            TestInvoker invoker = new TestInvoker();

            Command runAll = new RunAllTestsCommand(allTests, testRunner);
            Command runNetwork = new RunNetworkTestsCommand(allTests, testRunner);
            Command runGUI = new RunGUITestsCommand(allTests, testRunner);

            invoker.addCommand(runGUI);

            System.out.println("=== Blierlenen Testler Çalıştırılıyor ===");
            invoker.runTests();
        }
}