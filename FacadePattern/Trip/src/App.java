public class App {
  public static void main(String[] args) {
    BookingFacade trip = new BookingFacade();
    trip.booking("US", "Belgium", "03-23-2023", "", 
                  "03-23-2023", "03-23-2023", "03-29-2023");
  } 
}