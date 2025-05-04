package Iterator;

import Composite.TestComponent;

//      Abstract Aggregate
//      Defines the interface for creating and accessing an iterator for a collection of TestComponents.
//      Provides methods for adding, retrieving, and counting TestComponents in the aggregate.
public interface AbstractTestAggregate {
    AbstractTestIterator createIterator();
    void add(TestComponent component);
    int getCount();
    TestComponent get(int idx);
}
