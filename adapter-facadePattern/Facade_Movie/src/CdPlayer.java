public class CdPlayer {
    Amplifier amp;
    public CdPlayer(Amplifier amp){
        this.amp = amp;
    }
    public void on(){
        System.out.println(" Cd Player ON" );
    }
    public void off(){
        System.out.println(" Cd Player OFF " );
    }
    public void eject(){
        System.out.println(" Cd Player EJECT " );
    }
    public void pause(){
        System.out.println(" Cd Player EJECT " );
    }
    public void play(String movie){
        System.out.println(" Cd player playing " + movie );

    }
    public void stop(){
        System.out.println(" Cd Player eject stopped");

    }
    
}
