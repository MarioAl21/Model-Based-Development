import java.util.ArrayList.*;
import java.util.*;

public class Object implements Subject {
    private double price;
    private String name;
    private String auctioneer;
    private Vector<Observer> bidders;

    public Object(String auctioneer, String name, double price) {
        this.price = price;
        this.name = name;
        this.auctioneer = auctioneer;
        bidders = new Vector<>();
    }

    public void registerObserver(Observer bidder) {
        bidders.add(bidder);
    }

    public void removeObserver(Observer bidder) {
        int index = bidders.indexOf(bidder);
        if(index >= 0)
         bidders.remove(index);
    }

    public void notifyObservers() {
        for(int index = 0; index <= bidders.size() - 1; index ++) 
            bidders.get(index).update(price);
    }

    public void setPrice(double price) {
        this.price = price;
        priceHasChanged();
    }

    public void priceHasChanged() {
        notifyObservers();
    }
}