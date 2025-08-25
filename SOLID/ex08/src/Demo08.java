
public class Demo08 {
    public static void main(String[] args) {
        // Demo with Bicycle
        Pedalable bike = new Bicycle();
        bike.pedal(5);

        // Demo with ElectricCar
        EnginePowered car = new ElectricCar();
        car.startEngine();
        Rechargeable rechargeableCar = (Rechargeable) car;
        rechargeableCar.recharge(20);
    }
}
