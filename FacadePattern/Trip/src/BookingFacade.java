public class BookingFacade {
    Flight f = new Flight();
    Room r   = new Room();

    public void booking(String from, String to, String date, String time, 
                        String type, String register_date, String leave_date) {
      String ans = f.bookFlight(from, to, date, time); 
      if(!ans.equals("y"))
       r.bookRoom(type, register_date, leave_date);
    }
}
