public class HomeTheaterFacade{
    Amplifier amp;
    Tuner tuner;
    DvdPlayer dvd;
    CdPlayer cd;
    Projector projector;
    TheaterLights lights;
    Screen screen;
    PocorponPoper poper;

    

    public HomeTheaterFacade(Amplifier amp,
    Tuner tuner,
    DvdPlayer dvd,
    CdPlayer cd,
    Projector projector,
    TheaterLights lights,
    Screen screen,
    PocorponPoper poper){
        this.amp = amp;
        this.tuner = tuner;
        this.dvd = dvd;
        this.cd = cd;
        this.projector= projector;
        this.lights = lights;
        this.screen = screen;
        this.poper = poper;
    }
    public void watchMovie(String movie){
        poper.on();
        poper.pop();
        lights.dim(10);
        screen.down();
        projector.wideScreenMode();
        amp.on();
        amp.setDvd(dvd);
        amp.setVolume(5);
        dvd.on();
        dvd.play(movie);
    }
    public void endMovie(){
        System.out.println("Get ready to watch a movie  ... ");
        poper.off();
        lights.on();
        screen.up();
        projector.off();
        amp.off();
        dvd.stop();
        dvd.eject();
        dvd.off();
    }

}
