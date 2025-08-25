public class Demo06 {
    public static void main(String[] args) {
        Aviary aviary = new Aviary();
        Bird sparrow = new Sparrow();
        Penguin penguin = new Penguin();

        aviary.release((Flyable) sparrow); // works
        aviary.observe(penguin); // penguin can't fly, but can be observed
        penguin.swim();
    }
}
