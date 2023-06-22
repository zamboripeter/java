package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Light extends AbstractActor {
    private boolean isOn;
    private Animation lightOn;
    private Animation lightOff;
    public Light(){
        isOn = false;
        this.lightOff = new Animation(
            "sprites/light_off.png"
        );
        this.lightOn = new Animation(
            "sprites/light_on.png"
        );

        setAnimation(lightOff);
    }

    private void updateLight(){
        if (this.isOn == true){
            setAnimation(this.lightOn);
        }
        else {
            setAnimation(this.lightOff);
        }
    }
    public void toggle(){
        this.isOn = !this.isOn;
        //setAnimation(this.isOn ? lightOn : lightOff)
        if (this.isOn){
            setAnimation(lightOn);
        }
        else {
            setAnimation(lightOff);
        }
    }

}
