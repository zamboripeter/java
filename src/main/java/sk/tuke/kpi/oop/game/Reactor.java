package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.gamelib.graphics.Animation;

//potomok ma rozsirene vlastnosti rodica
public class Reactor extends AbstractActor {
    private int temperature;
    private boolean state;
    private int damage;
    private Animation normalAnimation;
    public Reactor(){
        this.temperature = 0;
        this.state = false;
        this.damage = 0;

        this.normalAnimation = new Animation(
            "sprites/reactor_on.png",
            80,
            80,
            0.1f,
            Animation.PlayMode.LOOP_PINGPONG);
        setAnimation(this.normalAnimation);

    }


    public int getTemperature(){
        return this.temperature;
    };
    public int getDamage(){
        return this.damage;
    }
    public void increaseTemperature(int increment){
        this.temperature += increment;
        if (this.temperature >= 2000) {
            if (this.temperature >= 6000) {
                this.damage = 100;
                return;
            }
        }
        int damage = (getTemperature()/40) - 50;

        if (this.damage < damage){
            this.damage = damage;
             }

        if (this.temperature > 4000){
            setAnimation(new Animation(
                "sprites/reactor_hot.png",
                80,
                80,
                0.01f,
                Animation.PlayMode.LOOP_PINGPONG));
        }
    }
}
