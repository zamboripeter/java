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
    private Animation hotAnimation;
    private Animation brokenAnimation;

    public Reactor() {
        this.temperature = 0;
        this.state = false;
        this.damage = 0;

        this.normalAnimation = new Animation(
            "sprites/reactor_on.png",
            80,
            80,
            0.1f,
            Animation.PlayMode.LOOP_PINGPONG);

        this.hotAnimation = new Animation(
            "sprites/reactor_hot.png",
            80,
            80,
            0.1f,
            Animation.PlayMode.LOOP_PINGPONG);

        this.brokenAnimation = new Animation(
            "sprites/reactor_broken.png",
            80,
            80,
            0.1f,
            Animation.PlayMode.LOOP_PINGPONG);

        // set default naimation
        setAnimation(this.normalAnimation);
    }


    public int getTemperature() {
        return this.temperature;
    }

    ;

    public int getDamage() {
        return this.damage;
    }

    public void increaseTemperature(int increment) {
        this.temperature = this.temperature + increment;

        if (this.damage == 100) {
            return;
        }

        //update information
        updateAnimation();
        // update damage
        if (this.temperature >= 2000) {
            if (this.temperature >= 6000) {
                this.damage = 100;
            } else {

                int damage = this.temperature / 40 - 50;

                // update when current damage is bigger than previous
                if (this.damage < damage) {
                    this.damage = damage;
                }
            }
        }

    }

    public void decreaseTemperature(int decrement) {
        this.temperature = this.temperature - decrement;
        if (this.damage == 100){
            return;
        }

       updateAnimation();

    }

    public void updateAnimation(){
        if (this.temperature >= 6000) {
            setAnimation(this.brokenAnimation);
        } else if (this.temperature >= 4000) {
            setAnimation(this.hotAnimation);
        } else  {
            setAnimation(this.normalAnimation);
        }
    }
}
