package Composite;

//      Leaf Class
//		represents leaf objects in the composition. A leaf has no children.
//	    Defines behavior for primitive objects in the composition.(Due to the safer way usage, addTest and removeTest does not included
//      in the Lead(TestCase) class.
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
}
