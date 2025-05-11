//      Iterator
//      Defines the interface for traversing elements in the aggregate without exposing its internal structure.
//      Provides methods to iterate over TestComponents in a sequence.
interface AbstractTestIterator {
    void first();
    void next();
    boolean isDone();
    TestComponent currentItem();
}


//      Concrete Iterator
//      Implements the iterator interface for traversing a collection of TestComponents (TestCase or TestSuite).
//      Provides sequential access to the elements in the TestSuite, keeping track of the current position.
 class TestSuiteIterator implements AbstractTestIterator {
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



//      Abstract Aggregate
//      Defines the interface for creating and accessing an iterator for a collection of TestComponents.
//      Provides methods for adding, retrieving, and counting TestComponents in the aggregate.
interface AbstractTestAggregate {
    AbstractTestIterator createIterator();
    void add(TestComponent component);
    int getCount();
    TestComponent get(int idx);
}
