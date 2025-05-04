package Composite;

import Iterator.AbstractTestAggregate;
import Iterator.AbstractTestIterator;
import Iterator.TestSuiteIterator;
import java.util.ArrayList;


//      Composite, ConcreteAggregate
//		defines behavior for components having children. Stores child
//		components. Implements child-related operations in the Component interface.
//      Concrete Aggregate: A concrete implementation of the Aggregate interface
public class TestSuite implements TestComponent, AbstractTestAggregate {
    private String name;
    private ArrayList<TestComponent> tests = new ArrayList<>();  // List of test components

    public TestSuite(String name) {
        this.name = name;  // Set the name of the test suite
    }

    public String getName() {
        return name;
    }

    // Create an iterator for the tests in the suite
    @Override
    public AbstractTestIterator createIterator() {
        return new TestSuiteIterator(tests);
    }

    // Add a test to the suite
    @Override
    public void add(TestComponent test) {
        tests.add(test);
    }

    // Return the number of tests in the suite
    @Override
    public int getCount() {
        return tests.size();
    }

    // Get a test by index
    @Override
    public TestComponent get(int idx) {
        return tests.get(idx);
    }

    // Remove a specific test from the suite
    @Override
    public void remove(TestComponent test) {
        tests.removeIf(t -> t.getName().equals(test.getName()));
    }

    // Execute all tests in the suite
    @Override
    public void execute() {
        System.out.println("[SUITE] Running suite: " + name);  // Display suite name
        for (TestComponent test : tests) {
            test.execute();  // Execute each test in the suite
        }
    }

    // Display all tests in the suite with indentation for nested tests
    @Override
    public void display(int indent) {
        for (int i = 0; i < indent; i++) System.out.print("-");
        System.out.println("+ TestSuite: " + name);
        for (TestComponent test : tests) {
            test.display(indent + 2);  // Display each test with increased indentation
        }
    }
}
