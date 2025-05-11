// CommandPattern sınıflarını import ediyoruz


public class FacadeAndSingleton {
    private static FacadeAndSingleton instance;
    private TestRunner testRunner;
    private TestSuite allTests;

    private FacadeAndSingleton(TestSuite allTests) {
        this.testRunner = new TestRunner();
        this.allTests = allTests;
    }

    public static FacadeAndSingleton getInstance(TestSuite allTests) {
        if (instance == null) {
            instance = new FacadeAndSingleton(allTests);
        }
        return instance;
    }

    protected void runAllTests() {
        System.out.println("=== Facade: All Tests Are Running ===");
        testRunner.runTestSuite(allTests);
    }

    protected void runGUITests() {
        System.out.println("=== Facade: GUI Testleri Çalıştırılıyor ===");
        filterAndRunTests(allTests, "GUI");
    }

    protected void runNetworkTests() {
        System.out.println("=== Facade: Network Testleri Çalıştırılıyor ===");
        filterAndRunTests(allTests, "Network");
    }

    // Kod tekrarını önlemek için BaseTestCommand sınıfındaki filterAndRunTests metodunu kullanıyoruz
    protected void filterAndRunTests(TestSuite suite, String keyword) {
        // BaseTestCommand sınıfındaki metodu kullanmak için geçici bir komut oluşturuyoruz
        BaseTestCommand command = new BaseTestCommand(suite, testRunner) {
            @Override
            public void execute() {
                // Bu metot kullanılmayacak, sadece filterAndRunTests metodunu kullanmak için
            }
        };
        command.filterAndRunTests(suite, keyword);
    }
}