public interface Subject {
    public void registerObserver(Observer bidder);
    public void removeObserver(Observer bidder);
    public void notifyObservers();
}
