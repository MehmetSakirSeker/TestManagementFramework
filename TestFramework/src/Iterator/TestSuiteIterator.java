package Iterator;

import Composite.TestComponent;
import Composite.TestSuite;

import java.util.ArrayList;

//      Concrete Iterator
//      Implements the iterator interface for traversing a collection of TestComponents (TestCase or TestSuite).
//      Provides sequential access to the elements in the TestSuite, keeping track of the current position.
public class TestSuiteIterator implements AbstractTestIterator {
    private TestSuite components;
    private int currentIndex = 0;

    public TestSuiteIterator(TestSuite components) {
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
        return currentIndex >= components.getCount();
    }

    @Override
    public TestComponent currentItem() {
        if (isDone()) {
            return null;
        }
        return components.get(currentIndex);
    }
}

