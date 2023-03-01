import static java.lang.System.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Room {
    // To sumulate the dalay into a room booking process
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

    // Print message to display after user choose their hotel room
    public void processingBooking(String hotel, String cost) {
        out.println("Paying for " + hotel + 
                    "\nprocessing payment");
             
        delay(2);

        out.println("Successful transaction!\n" +
                         "Sending invoice for " + cost + " to the associated card...");

        delay(1);

        out.println("Done.");
        out.println("\t***** Enjoy your stay *****");
    }
    
    // Books a Room (from a hotel of course)
    public void bookRoom(String type, String register_date, String leave_date) {
        out.println("Searching for a hotel room for " + register_date + " to " + leave_date + " and " + type);
        
        delay(4);

        out.println("\nOptions available: " +
                    "\n\t1. Meininger Hotel -> $231" +
                    "\n\t2. Ibis budget Aechen -> $241" +
                    "\n\t3. Orange hotel -> $310\n*Yeah, just another three options again.");

        String opc;
        Scanner scan = new Scanner(System.in);
        
        do {
         out.print("\nChoose your option: ");
         opc = scan.nextLine();
         switch(opc) {
            case "1":
             processingBooking("Meininger Hotel room", "$231");             
            break; 
            case "2":
             processingBooking("Ibis budget Aechen Hotel room", "$241");             
            break; 
            case "3":
             processingBooking("Orange Hotel room", "$310");             
            break; 
            default: 
             out.print("Option doesn't elisted!\nPlease, select some one in it" + 
                         "\nCancel operation? \n\t(Y)yes, Cancel \n\t(N *or another)no, I wan to to choose my hotel room\nChoose: ");
             opc = scan.nextLine().toLowerCase();
             if(opc.equals("y"))
              out.println("Room Booking Cancelled");            
         }
        } while(!opc.equals("1") && !opc.equals("2") && !opc.equals("3") && !opc.equals("y"));
    }
}
