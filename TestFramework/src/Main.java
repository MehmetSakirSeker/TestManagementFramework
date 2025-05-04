import Composite.TestCase;
import Composite.TestComponent;
import Composite.TestSuite;
import Iterator.AbstractTestIterator;

public class Main {
    public static void main(String[] args) {


        TestCase test1 = new TestCase("Test 1");
        TestCase test2 = new TestCase("Test 2");
        TestCase test3 = new TestCase("Test 3");
        TestCase test4 = new TestCase("Test 4");
        TestCase test5 = new TestCase("Test 5");


        TestSuite suite1 = new TestSuite("Main Test Suite");
        suite1.add(test1);
        suite1.add(test2);
        suite1.add(test3);


        TestSuite subSuite1 = new TestSuite("Sub Suite 1");
        subSuite1.add(test4);
        subSuite1.add(test5);


        suite1.add(subSuite1);


        System.out.println("Displaying all tests in the main test suite:");
        suite1.display(0);


        System.out.println("\nExecuting all tests in the main test suite:");
        suite1.execute();


        System.out.println("\nIterating over tests using Iterator:");
        AbstractTestIterator iterator = suite1.createIterator();
        while (!iterator.isDone()) {
            TestComponent test = iterator.currentItem();
            test.execute();
            iterator.next();
        }

        System.out.println("\nDisplaying all tests after iteration:");
        suite1.display(0);
    }
}