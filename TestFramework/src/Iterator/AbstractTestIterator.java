package Iterator;

import Composite.*;

//      Iterator
//      Defines the interface for traversing elements in the aggregate without exposing its internal structure.
//      Provides methods to iterate over TestComponents in a sequence.
public interface AbstractTestIterator {
    void first();
    void next();
    boolean isDone();
    TestComponent currentItem();
}
