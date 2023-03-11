import java.io.*;

public class GraniteFacade extends Facade {
    @Override
    public boolean addMaterial() {
        boolean res = false;
        String ans = "";
        System.out.print("Add Polished laminate? (Y)Yes (N)No, select your option: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            ans = br.readLine();
            ans.toLowerCase();
        } catch(IOException e) {
            System.out.println("Issues " + e.getMessage());
        }

        if(ans.equals("y"))
         material += " - polished";

        return res;
    }

    public GraniteFacade() {
        material = "granite";
    }
}

