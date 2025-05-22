interface TransportStrategy {
    void go(String source, String destination);
}

class BikeStrategy implements TransportStrategy {
    public void go(String source, String destination) {
        System.out.println("Going from " + source + " to " + destination + " by Bike.");
    }
}

class BusStrategy implements TransportStrategy {
    public void go(String source, String destination) {
        System.out.println("Going from " + source + " to " + destination + " by Bus.");
    }
}

class CarStrategy implements TransportStrategy {
    public void go(String source, String destination) {
        System.out.println("Going from " + source + " to " + destination + " by Car.");
    }
}

class NavigationService {
    private TransportStrategy strategy;
    public void setTransportStrategy(TransportStrategy strategy) {
        this.strategy = strategy;
    }
    public void navigate(String source, String destination) {
        if (strategy == null) {
            System.out.println("Please select a transport strategy.");
        } else {
            strategy.go(source, destination);
        }
    }
}

class StrategyPatternDemo {
    public static void main(String[] args) {
        NavigationService navService = new NavigationService();
        navService.setTransportStrategy(new BikeStrategy());
        navService.navigate("Home", "Office");
        navService.setTransportStrategy(new BusStrategy());
        navService.navigate("Home", "City Center");
        navService.setTransportStrategy(new CarStrategy());
        navService.navigate("Home", "Airport");
    }
}