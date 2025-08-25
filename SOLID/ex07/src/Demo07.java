public class Demo07 {
    public static void main(String[] args) {
    Printer printer = new BasicPrinter();
    printer.print("Hello");

    // Uncomment to demo advanced printer
    Scanner scanner = new AdvancedPrinter();
    scanner.scan("/tmp/out");
    }
}
