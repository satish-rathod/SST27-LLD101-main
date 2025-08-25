public class AdvancedPrinter implements Printer, Scanner {
    @Override
    public void print(String text) {
        System.out.println("Print: " + text);
    }

    @Override
    public void scan(String dstPath) {
        System.out.println("Scanning to: " + dstPath);
    }
}
