package Composite;

import Iterator.AbstractTestIterator;


//      Leaf Class
//		represents leaf objects in the composition. A leaf has no children.
//	    Defines behavior for primitive objects in the composition.(Due to the safer way usage, addTest and removeTest does not included
//      in the Lead(TestCase) class.
//      Concrete Aggregate because of test component transparent not safe
public class TestCase implements TestComponent {
    private String name;

    public TestCase(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void add(TestComponent test) {
        System.out.println("Cannot add to a TestCase(Leaf).");
    }

    @Override
    public void remove(TestComponent test) {
        System.out.println("Cannot remove from a TestCase(Leaf).");
    }

    @Override
    public void execute() {
        System.out.println("[RUNNING] " + name);

    }

    @Override
    public void display(int indent) {
        for (int i = 0; i < indent; i++) System.out.print("-");
        System.out.println(" TestCase: " + name);
    }
    @Override
    public AbstractTestIterator createIterator() {
        // Leaf should not create an iterator
        throw new UnsupportedOperationException("Leaf nodes do not support iterators");
    }

    //Leaf does not have children so count is 0
    @Override
    public int getCount() {
        return 0;
    }

    //Leaf does not have sub leafs so leaf cant get a node
    @Override
    public TestComponent get(int idx) {
        throw new UnsupportedOperationException("Leaf has no children.");
    }
}
