public class ChangeLights implements Command {
    private House house;

    public ChangeLights(House house) {
        this.house = house;
    }

    public void execute() {
        house.setLights(!house.lightsAre());
        String lights_are = house.lightsAre() ? "on" : "off";
        System.out.println("Lights are " + lights_are);
    }
}
