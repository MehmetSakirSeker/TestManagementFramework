import Composite.TestComponent;
import Composite.TestSuite;
import Iterator.AbstractTestIterator;

import java.util.ArrayList;
import java.util.List;

// Command arayüzü
interface Command {
    void execute();
}

// Receiver
class TestRunner {
    public void runTest(TestComponent testComponent) {
        System.out.println("[RUNNING] " + testComponent.getName());
        testComponent.execute();
    }

    public void runTestSuite(TestSuite suite) {
        System.out.println("[SUITE] " + suite.getName());
        AbstractTestIterator iterator = suite.createIterator();
        for (iterator.first(); !iterator.isDone(); iterator.next()) {
            TestComponent testComponent = iterator.currentItem();
            if (testComponent instanceof TestSuite) {
                runTestSuite((TestSuite) testComponent);
            } else {
                runTest(testComponent);
            }
        }
    }
}

// Base Command
abstract class BaseTestCommand implements Command {
    protected TestSuite testSuite;
    protected TestRunner testRunner;

    public BaseTestCommand(TestSuite testSuite, TestRunner testRunner) {
        this.testSuite = testSuite;
        this.testRunner = testRunner;
    }

    protected void filterAndRunTests(TestSuite suite, String keyword) {
        AbstractTestIterator iterator = suite.createIterator();
        for (iterator.first(); !iterator.isDone(); iterator.next()) {
            TestComponent component = iterator.currentItem();
            if (component.getName().contains(keyword)) {
                if (component instanceof TestSuite) {
                    testRunner.runTestSuite((TestSuite) component);
                } else {
                    testRunner.runTest(component);
                }
            } else if (component instanceof TestSuite) {
                filterAndRunTests((TestSuite) component, keyword);
            }
        }
    }

}

// Concrete Commands
class RunAllTestsCommand extends BaseTestCommand {
    public RunAllTestsCommand(TestSuite testSuite, TestRunner testRunner) {
        super(testSuite, testRunner);
    }

    public void execute() {
        testRunner.runTestSuite(testSuite);
    }
}

class RunGUITestsCommand extends BaseTestCommand {
    public RunGUITestsCommand(TestSuite testSuite, TestRunner testRunner) {
        super(testSuite, testRunner);
    }

    public void execute() {
        filterAndRunTests(testSuite, "GUI");
    }
}

class RunNetworkTestsCommand extends BaseTestCommand {
    public RunNetworkTestsCommand(TestSuite testSuite, TestRunner testRunner) {
        super(testSuite, testRunner);
    }

    public void execute() {
        filterAndRunTests(testSuite, "Network");
    }

}

// Invoker
class TestInvoker {
    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void runTests() {
        for (Command command : commands) {
            command.execute();
        }
        commands.clear();
    }
}