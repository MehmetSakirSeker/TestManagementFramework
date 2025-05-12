import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException{

        TestCreator creator = new AixTestCreator();
        ArrayList<TestComponent> tests = creator.createTest();

        TestSuite allTests = new TestSuite("All Tests");
        for (TestComponent test : tests) {
            allTests.add(test);
        }

        TestManager manager = TestManager.getInstance(allTests);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Which test do you want to run?");
        System.out.println("1 - All Tests");
        System.out.println("2 - GUI Tests");
        System.out.println("3 - Network Tests");
        System.out.println("4 - Run all tests every monday");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> manager.runAllTests();
            case 2 -> manager.runGUITests();
            case 3 -> manager.runNetworkTests();
            case 4 -> {

                System.out.println("Project Leader, please choose which tests to run on monday automatically:");
                System.out.println("1 - All Tests");
                System.out.println("2 - GUI Tests");
                System.out.println("3 - Network Tests");
                int subChoice = scanner.nextInt();

                testOnMonday(DayOfWeek.MONDAY, 1000);
                switch (subChoice) {
                    case 1 -> manager.runAllTests();
                    case 2 -> manager.runGUITests();
                    case 3 -> manager.runNetworkTests();
                    default -> System.out.println("Invalid choice.");
                }
            }
            default -> System.out.println("Invalid choice.");
        }

        scanner.close();
    }

    public static void testOnMonday(DayOfWeek targetDay, int millisPerDay) throws InterruptedException {

        DayOfWeek today = LocalDate.now().getDayOfWeek();

        while (today != targetDay) {
            System.out.println("Today is " + today + ". Waiting for " + targetDay + "...");
            Thread.sleep(millisPerDay);
            today = today.plus(1);
        }

        System.out.println("It's " + targetDay + "! Running tests now...");
    }
}

