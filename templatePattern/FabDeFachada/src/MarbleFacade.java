import java.io.*;

public class MarbleFacade extends Facade {
    @Override
    public boolean addMaterial() {
        boolean res = false;
        String ans = "";
        System.out.print("Add Albujadado laminate? (Y)Yes (N)No, select your option: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            ans = br.readLine();
            ans.toLowerCase();
        } catch(IOException e) {
            System.out.println("Issues " + e.getMessage());
        }

        if(ans.equals("y"))
         material += " - alburjadado";

        return res;
    }

    public MarbleFacade() {
        material = "marble";
    }
}
