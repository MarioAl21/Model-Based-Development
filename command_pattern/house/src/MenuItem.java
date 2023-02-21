public class MenuItem {
    private final String name;
    private final Command command;

    public MenuItem(String name, Command command) {
        this.name    = name;
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }

    public String name() {
        return name;
    }
}
