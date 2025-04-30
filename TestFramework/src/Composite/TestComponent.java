package Composite;

//      This is the "Component".
//		Declares the interface for objects in the composition. Implements
//      default behavior for the interface common to all classes, as
//      appropriate. declares an interface for accessing and managing its
//		child components.
public interface TestComponent {
    void add(TestComponent test);
    void remove(TestComponent test);
    void execute();
    void display(int indent);
    String getName();
}