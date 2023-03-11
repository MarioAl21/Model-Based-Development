import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public abstract class Facade {
    protected String material = "material";
    private float length, width;

    final void prepareFacade() throws IOException {
     // Steps to prepare the facade   
     laminateStone();
     try {
      requestMeasures();
      // Template method
      if(length != 0.0 && width != 0.0) {
       addMaterial();
       packInFive();
      }   
      else
       System.out.println("Issues with your measures!!! Try again (run the program once more)");
     } catch(NumberFormatException e) {
        System.out.println("");
     }
    }

    // The user choice is among of alburjadado, polished, ludo
    abstract boolean addMaterial();

    void laminateStone() {
        System.out.println("Rolling stone");
    }

    void requestMeasures() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Introduce length: ");
            length = Float.parseFloat(br.readLine());
            System.out.print("Introduce width: ");
            width = Float.parseFloat(br.readLine());
        } catch(NumberFormatException e) {
            System.out.println("Issues " + e.getMessage());
        }
    }

    public void packInFive() {
        System.out.println("Packaging " + material + " in groups of five with following measurements " + length + " x " + width);
    }
}
