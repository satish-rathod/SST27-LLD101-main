public class Demo10 {
    public static void main(String[] args) {
        Logger logger = new ConsoleLogger();
        ReportService reportService = new ReportService(logger);
        reportService.generate();

        // Tiny demo/test: generate again with a different logger (anonymous)
        Logger testLogger = new Logger() {
            @Override
            public void log(String msg) {
                System.out.println("[TEST-LOG] " + msg);
            }
        };
        new ReportService(testLogger).generate();
    }
}
