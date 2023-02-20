public class None extends DiscountDecorator {
    Printer printer;

    public None(Printer printer) {
        this.printer = printer;
    }

    public String getModel() {
        return printer.getModel() + " with None discount";
    }

    public double cost() {
        return printer.cost();
    }
}