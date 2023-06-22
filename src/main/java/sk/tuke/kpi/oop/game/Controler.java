package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Controler extends AbstractActor {

    private Reactor reactor;
    public Controler(Reactor reactor) {
        this.reactor = reactor;
        Animation controler = new Animation(
            "sprites/switch.png"
        );
        setAnimation(controler);
    }

    public void toggle(){
            if (this.reactor.isRunning()){
                this.reactor.turnOff();
            }
            else {
                this.reactor.turnOn();
            }
    }
}
