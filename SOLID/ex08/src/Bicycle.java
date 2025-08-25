public class Bicycle implements Vehicle, Pedalable {
    @Override
    public void pedal(int effort) {
        System.out.println("Pedal effort " + effort);
    }
}