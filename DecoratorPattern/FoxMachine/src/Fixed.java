public class Fixed extends DiscountDecorator {
    private Printer printer;
    double discount;

    public Fixed(Printer printer, double discount) {
        this.printer = printer;
        this.discount = discount;   
    }

    public String getModel() {
        return printer.getModel() + " + <<Fixed discount (" + discount + " off)>>";
    }

    public double cost() {
        return (printer.cost() - printer.cost() * discount); 
    }
}