//Our Component
public abstract class Printer {
    protected String model;

    public String getModel() {
        return model;
    }

    public abstract double cost();
}
