// Marker interface for all vehicles
public interface Vehicle {
}

// Interface for vehicles with engines
interface EnginePowered {
    void startEngine();
}

// Interface for vehicles that can be pedaled
interface Pedalable {
    void pedal(int effort);
}

// Interface for vehicles that can be recharged
interface Rechargeable {
    void recharge(int kWh);
}