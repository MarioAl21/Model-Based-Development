public class Amplifier {
    DvdPlayer dvd;

    public Amplifier(DvdPlayer dvd){
        this.dvd = dvd;
    }

    public void on(){
        System.out.println(" Top 0 Line Projector on");
    }

    public void off(){
        System.out.println(" Top 0 Line Projector off");
    }

    public void setDvd(DvdPlayer dvd){
        //Agregar la funcion de dvd
        System.out.println(" Top 0  Amplifier setting DVD player ");
    }

    public void setSorroundSound(){
        System.out.println(" Top 0  Amplifier sorround sound on (5 speakers, 1 subwooffer) ");
    }

    public void setVolume(int volume){
        System.out.println(" Top 0  Line Amplifier in volume" + volume );
    }


}
