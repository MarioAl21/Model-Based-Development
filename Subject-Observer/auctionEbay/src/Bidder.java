public class Bidder implements Observer {
    private Subject object;
    private double bid;
    private String name;

    public Bidder(Subject object, String name) {
        this.object = object;
        this.name = name;
        object.registerObserver(this);
    }

    public void update(double price) {
        display(price);
    }

    public void display(double price) {
        System.out.println("\nThe price has changed " + name + "!\n. ----New Price: " + price + "------");
    }

    public double offer(double bid) {
        this.bid = bid;
        return bid;
    }
}