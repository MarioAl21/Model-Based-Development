public class LoyalPartner extends DiscountDecorator {
    private Printer printer;

    public LoyalPartner(Printer printer) {
        this.printer = printer;
    }

    public String getModel() {
        return printer.getModel() + "  + <<Loyale partern discount (15% off)>>";
    }

    public double cost() {
        return (printer.cost() - printer.cost() * 0.15); 
    }
}