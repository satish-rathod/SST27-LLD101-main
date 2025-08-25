public class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle() {
        this.width = 0;
        this.height = 0;
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int area() {
        return width * height;
    }
}