import java.io.*;

public class SandStoneFacade extends Facade {
    @Override
    public boolean addMaterial() {
        boolean res = false;
        String ans = "";
        System.out.print("Add Lud laminate? (Y)Yes (N)No, select your option: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            ans = br.readLine();
            ans.toLowerCase();
        } catch(IOException e) {
            System.out.println("Issues " + e.getMessage());
        }

        if(ans.equals("y"))
         material += " - Lud";

        return res;
    }

    public SandStoneFacade() {
        material = "sand stone";
    }
}


