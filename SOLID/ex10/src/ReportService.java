public class ReportService {
    private final Logger logger;

    public ReportService(Logger logger) {
        this.logger = logger;
    }

    public void generate() {
        logger.log("Generating daily report...");
        System.out.println("Report contents...");
    }
}