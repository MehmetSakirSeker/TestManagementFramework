import java.util.ArrayList;

abstract class TestCreator{

    private ArrayList<TestComponent> testComponents;
    abstract TestComponent createGUITestCase();
    abstract TestComponent createGUITestSuite();
    abstract TestComponent createNetworkTestCase();
    abstract TestComponent createNetworkTestSuite();

    public ArrayList<TestComponent> createTest(){
        testComponents = new ArrayList<>();
        testComponents.add(createGUITestCase());
        testComponents.add(createGUITestSuite());
        testComponents.add(createNetworkTestCase());
        testComponents.add(createNetworkTestSuite());
        return testComponents;
    }
}

class AixTestCreator extends TestCreator{
    @Override
    public TestComponent createGUITestCase(){
        return new TestCase("Aix GUI – Single Button Test");
    }
    @Override
    public TestComponent createGUITestSuite(){
        TestSuite suite = new TestSuite("Aix GUI Test Suite");
        suite.add(new TestCase("Aix GUI - Button Test"));
        suite.add(new TestCase("Aix GUI - Window Resize Test"));
        suite.add(new TestCase("Aix GUI - Menu Test"));
        return suite;
    }
    @Override
    public TestComponent createNetworkTestCase(){
        return new TestCase("Aix Network – Simple Ping Test");
    }
    @Override
    public TestComponent createNetworkTestSuite(){
        TestSuite suite = new TestSuite("Aix Network Test Suite");
        suite.add(new TestCase("Aix Network - Ping Test"));
        suite.add(new TestCase("Aix Network - Port Scan Test"));
        suite.add(new TestCase("Aix Network - DNS Resolution Test"));
        return suite;
    }
}

class MacTestCreator extends TestCreator{
    @Override
    public TestComponent createGUITestCase(){
        return new TestCase("Mac GUI – Dark Mode Toggle Test");
    }
    @Override
    public TestComponent createGUITestSuite(){
        TestSuite suite = new TestSuite("Mac GUI Test Suite");
        suite.add(new TestCase("Mac GUI - Scroll Test"));
        suite.add(new TestCase("Mac GUI - Dark Mode Test"));
        suite.add(new TestCase("Mac GUI – Retina Display Adjustment Test"));
        return suite;
    }
    @Override
    public TestComponent createNetworkTestCase(){
        return new TestCase("Mac Network – Basic Connectivity Test");
    }
    @Override
    public TestComponent createNetworkTestSuite(){
        TestSuite suite = new TestSuite("Mac Network Test Suite");
        suite.add(new TestCase("Mac Network - Ping Test"));
        suite.add(new TestCase("Mac Network - Firewall Rule Test"));
        suite.add(new TestCase("Mac Network – Proxy Detection Test"));
        return suite;
    }
}

class TestSystem {
    public static void main(String[] args) {
        TestCreator creator = new AixTestCreator();

        ArrayList<TestComponent> tests = creator.createTest();

        System.out.println("=== Executing All Tests ===");
        for (TestComponent test : tests) {
            test.display(0);
            test.execute();
            System.out.println();
        }
    }
}
