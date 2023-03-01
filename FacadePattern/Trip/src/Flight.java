import static java.lang.System.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Flight {
    // To delay runing time that allows to simulate a booking flight process
    public void delay(int time_to_delay) {
        int delay = 0;
        TimeUnit t = TimeUnit.SECONDS;

        try {
            while(delay <= time_to_delay) {
               out.println("...");
               t.sleep(2L);
               delay ++;
           }
       } catch(InterruptedException e) {
           System.out.println("Interrupted ");
       }
    }

    // Print message to display after user choose their Airline
    public void processingBooking(String airline, String cost) {
        out.println("Paying for " + airline + 
                    "\nprocessing payment");
             
        delay(2);

        out.println("Successful transaction!\n" +
                         "Sending invoice for " + cost + " to the associated card...");

        delay(1);

        out.println("Done.");
        out.println("\t***** Enjoy your flight *****");
    }
    
    // Books a flight
    public String bookFlight(String from, String to, String date, String time) {
        out.println("Searching for a flight for " + date + " at " + time +
                    " from " + from + " to " + to);
        
        delay(4);

        out.println("\nOptions available: " +
                    "\n\t1. United Airlines at 12:30pm platform 7 -> $212" + 
                    "\n\t2. Delta Air Lines at 12:43pm platform 9 -> $189" +
                    "\n\t3. United Airlines at 13:45pm platform 7 -> $208");

        String opc;
        Scanner scan = new Scanner(System.in);
        
        do {
         out.print("\nChoose your option: ");
         opc = scan.nextLine();
         switch(opc) {
            case "1":
             processingBooking("United Airlines at 12:30pm platform 7", "$212");             
            break; 
            case "2":
             processingBooking("Delta Air Lines at 12:43pm platform 9", "$189");             
            break; 
            case "3":
             processingBooking("United Airlines at 13:45pm platform 7", "$208");             
            break; 
            default: 
             out.print("Option doesn't elisted!\nPlease, select some one in it" + 
                         "\nCancel operation? \n\t(Y)yes, Cancel \n\t(N *or another)no, I wan to to choose my flight\nChoose: ");
             opc = scan.nextLine().toLowerCase();
             if(opc.equals("y"))
              out.println("Flight Booking Cancelled");            
         }
        } while(!opc.equals("1") && !opc.equals("2") && !opc.equals("3") && !opc.equals("y"));

        return opc;
    }
}
