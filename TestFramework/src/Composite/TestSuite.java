package Composite;

import java.util.ArrayList;


//      Composite
//		defines behavior for components having children. Stores child
//		components. Implements child-related operations in the Component interface.
public class TestSuite implements TestComponent {
    private String name;
    private ArrayList<TestComponent> tests = new ArrayList<>();

    public TestSuite(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void add(TestComponent test) {
        tests.add(test);
    }

    @Override
    public void remove(TestComponent test) {
        tests.removeIf(t -> t.getName().equals(test.getName()));
    }

    @Override
    public void execute() {
        System.out.println("[SUITE] Running suite: " + name);
        for (TestComponent test : tests) {
            test.execute();
        }
    }

    @Override
    public void display(int indent) {
        for (int i = 0; i < indent; i++) System.out.print("-");
        System.out.println("+ TestSuite: " + name);
        for (TestComponent test : tests) {
            test.display(indent + 2);
        }
    }
}
