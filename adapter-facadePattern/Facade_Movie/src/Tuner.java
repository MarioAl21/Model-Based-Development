public class Tuner {
    Amplifier amp;
    public Tuner(Amplifier amp){
        this.amp = amp;
    }
    public void on(){
        System.out.println(" Tuner ON" );
    }
    public void off(){
        System.out.println(" Tuner OFF " );
    }
    public void setAmp(Amplifier amp){
      
    }
    public int setFre(int frecuencia)
    {
        return frecuencia;
        
    }
    
}
