interface Car {
    String getDescription();
    double getCost();
}

class BasicCar implements Car {
    public String getDescription() {
        return "Basic Car";
    }
    public double getCost() {
        return 500000;
    }
}

abstract class CarDecorator implements Car {
    protected Car decoratedCar;
    public CarDecorator(Car car) {
        this.decoratedCar = car;
    }
    public String getDescription() {
        return decoratedCar.getDescription();
    }
    public double getCost() {
        return decoratedCar.getCost();
    }
}

class Sunroof extends CarDecorator {
    public Sunroof(Car car) {
        super(car);
    }
    public String getDescription() {
        return decoratedCar.getDescription() + ", Sunroof";
    }
    public double getCost() {
        return decoratedCar.getCost() + 80000;
    }
}

class SportSeats extends CarDecorator {
    public SportSeats(Car car) {
        super(car);
    }
    public String getDescription() {
        return decoratedCar.getDescription() + ", Sport Seats";
    }
    public double getCost() {
        return decoratedCar.getCost() + 60000;
    }
}

class SoundSystem extends CarDecorator {
    public SoundSystem(Car car) {
        super(car);
    }
    public String getDescription() {
        return decoratedCar.getDescription() + ", Premium Sound System";
    }
    public double getCost() {
        return decoratedCar.getCost() + 40000;
    }
}

class DecoratorPatternDemo {
    public static void main(String[] args) {
        Car myCar = new BasicCar();
        myCar = new Sunroof(myCar);
        myCar = new SportSeats(myCar);
        myCar = new SoundSystem(myCar);
        System.out.println("Description: " + myCar.getDescription());
        System.out.println("Total Cost: ₹" + myCar.getCost());
    }
}