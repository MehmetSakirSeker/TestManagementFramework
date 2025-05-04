package Iterator;

import Composite.TestComponent;

import java.util.ArrayList;

//      Concrete Iterator
//      Implements the iterator interface for traversing a collection of TestComponents (TestCase or TestSuite).
//      Provides sequential access to the elements in the TestSuite, keeping track of the current position.
public class TestSuiteIterator implements AbstractTestIterator {
    private ArrayList<TestComponent> components;
    private int currentIndex = 0;

    public TestSuiteIterator(ArrayList<TestComponent> components) {
        this.components = components;
    }

    @Override
    public void first() {
        currentIndex = 0;
    }

    @Override
    public void next() {
        currentIndex++;
    }

    @Override
    public boolean isDone() {
        return currentIndex >= components.size();
    }

    @Override
    public TestComponent currentItem() {
        if (isDone()) {
            return null;
        }
        return components.get(currentIndex);
    }
}

