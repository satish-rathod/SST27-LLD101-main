
public class Demo05 {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        rect.setWidth(5);
        rect.setHeight(4);
        System.out.println("Rectangle area: " + rect.area()); // 20

        Square square = new Square();
        square.setSide(4);
        System.out.println("Square area: " + square.area()); // 16
    }
}
