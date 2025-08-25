public class ElectricCar implements Vehicle, EnginePowered, Rechargeable {
    @Override
    public void startEngine() {
        System.out.println("Electric car engine started.");
    }

    @Override
    public void recharge(int kWh) {
        System.out.println("Recharged car with " + kWh + " kWh.");
    }
}
