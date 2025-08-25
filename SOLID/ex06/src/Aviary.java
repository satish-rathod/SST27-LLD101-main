class Aviary {
    public void release(Flyable f) {
        f.fly();
        System.out.println("Released");
    }
    public void observe(Bird b) {
        b.makeSound();
    }
}