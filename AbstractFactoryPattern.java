interface Button {
    void click();
}

interface Checkbox {
    void check();
}

class DarkButton implements Button {
    public void click() {
        System.out.println("Dark Button Clicked");
    }
}

class LightButton implements Button {
    public void click() {
        System.out.println("Light Button Clicked");
    }
}

class DarkCheckbox implements Checkbox {
    public void check() {
        System.out.println("Dark Checkbox Checked");
    }
}

class LightCheckbox implements Checkbox {
    public void check() {
        System.out.println("Light Checkbox Checked");
    }
}

interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

class DarkUIFactory implements UIFactory {
    public Button createButton() { return new DarkButton(); }
    public Checkbox createCheckbox() { return new DarkCheckbox(); }
}

class LightUIFactory implements UIFactory {
    public Button createButton() { return new LightButton(); }
    public Checkbox createCheckbox() { return new LightCheckbox(); }
}

class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        UIFactory factory = new DarkUIFactory();
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();
        button.click();
        checkbox.check();
    }
}