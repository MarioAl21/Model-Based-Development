public class FivePercentOff extends DiscountDecorator {
    private Printer printer;

    public FivePercentOff(Printer printer) {
        this.printer = printer;
    }

    public String getModel() {
        return printer.getModel() + " + <<five percent Off>>";
    }

    public double cost() {
        return (printer.cost() - (0.05 * printer.cost())); 
    }
}