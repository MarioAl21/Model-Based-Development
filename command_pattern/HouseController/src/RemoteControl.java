import java.util.*;

// Invoker
public class RemoteControl {
    private Map<String, Command> commands = new HashMap<>();

    public void setCommand(String button, Command command) {
        commands.put(button, command);
    }

    public void buttonWasPushed(String button) {
        if(commands.containsKey(button))
         commands.get(button).execute();
        else
         System.out.println("No command for button: " + button);
    }
}
