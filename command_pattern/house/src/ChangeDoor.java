public class ChangeDoor implements Command {
    House house;

    public ChangeDoor(House house) {
        this.house = house;
    }

    public void execute() {
        house.setDoor(!house.doorIs());
        String door_is = house.doorIs() ? "open" : "closed";
        System.out.println("The door is: " + door_is);
    } 
}
