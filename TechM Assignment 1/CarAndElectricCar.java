// Car class
class Car {
    private String make;
    private String model;
    private int year;

    // Constructor
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Getters and Setters
    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    // Method to start the engine
    public void startEngine() {
        System.out.println("The " + make + " " + model + "'s engine has started.");
    }
}

// ElectricCar subclass
class ElectricCar extends Car {
    private int batteryRange;

    // Constructor
    public ElectricCar(String make, String model, int year, int batteryRange) {
        super(make, model, year);
        this.batteryRange = batteryRange;
    }

    // Method to charge the battery
    public void chargeBattery() {
        System.out.println("The " + getMake() + " " + getModel() + "'s battery is being charged.");
    }
}

// Main class to demonstrate polymorphism
public class CarAndElectricCar {
    public static void main(String[] args) {
        Car[] cars = {
            new Car("Toyota", "Corolla", 2020),
            new ElectricCar("Tesla", "Model S", 2023, 400)
        };

        for (Car car : cars) {
            car.startEngine(); // Polymorphism in action
        }
    }
}