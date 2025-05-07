import Composite.TestCase;
import Composite.TestComponent;
import Composite.TestSuite;
import Iterator.AbstractTestIterator;

public class Main {
    public static void main(String[] args) {

        // Leaf'ler (TestCase)
        TestCase test1 = new TestCase("Test 1");
        TestCase test2 = new TestCase("Test 2");
        TestCase test3 = new TestCase("Test 3");
        TestCase test4 = new TestCase("Test 4");
        TestCase test5 = new TestCase("Test 5");

        // Composite (Ana test suite)
        TestSuite suite1 = new TestSuite("Main Test Suite");
        suite1.add(test1);
        suite1.add(test2);
        suite1.add(test3);

        // Composite (Alt test suite)
        TestSuite subSuite1 = new TestSuite("Sub Suite 1");
        subSuite1.add(test4);
        subSuite1.add(test5);

        // Alt suite'i ana suite'e ekle
        suite1.add(subSuite1);

        // 1. Tüm testleri göster
        System.out.println("=== Displaying test hierarchy ===");
        suite1.display(0);

        // 2. Tüm testleri çalıştır
        System.out.println("\n=== Executing all tests ===");
        suite1.execute();

        // 3. Iterator ile testleri sırayla çalıştır
        System.out.println("\n=== Iterating with Iterator (only direct children) ===");
        AbstractTestIterator iterator = suite1.createIterator();
        while (!iterator.isDone()) {
            TestComponent test = iterator.currentItem();
            System.out.print("Iterating: ");
            test.execute();
            iterator.next();
        }

        // 4. Bir leaf için iterator denemesi
        System.out.println("\n=== Trying iterator on a leaf node ===");
        try {
            AbstractTestIterator leafIterator = test1.createIterator();
            if (leafIterator.isDone()) {
                System.out.println("Leaf test case has no children to iterate.");
            }
        }catch (UnsupportedOperationException e){
            e.printStackTrace();
        }finally {
            // 5. Tüm testleri tekrar göster
            System.out.println("\n=== Final display ===");
            suite1.display(0);
        }



    }
}
