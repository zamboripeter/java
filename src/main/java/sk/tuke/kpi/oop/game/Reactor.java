package sk.tuke.kpi.oop.game;


import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.gamelib.graphics.Animation;

//potomok ma rozsirene vlastnosti rodica
public class Reactor extends AbstractActor {
    private Light light;
    private int temperature;
    private boolean state;
    private int damage;
    private Animation normalAnimation;
    private Animation hotAnimation;
    private Animation brokenAnimation;
    private Animation buyAnimation;

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

        this.buyAnimation = new Animation(
            "sprites/reactor.png",
            80,
            80
        );
        // set default naimation
        setAnimation(this.buyAnimation);
    }

    public void addLight(Light light){
        this.light = light;
       }
    public int getTemperature() {
        return this.temperature;
    }

    ;

    public int getDamage() {
        return this.damage;
    }

    public void increaseTemperature(int increment) {
            if (increment < 0 || !isRunning()) {    //!isRunning() ak neplatí
                return;
            }
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
        if (decrement < 0 || !isRunning()){
            return;
        }
        this.temperature = this.temperature - decrement;
        if (this.damage == 100){
            return;
        }

       updateAnimation();

    }

    private void updateAnimation(){
                if (this.temperature >= 6000) {
                    setAnimation(this.brokenAnimation);
                } else if (this.temperature >= 4000) {
                    setAnimation(this.hotAnimation);
                } else {
                    setAnimation(this.normalAnimation);
                }
        }



    public void turnOn() {
        if (this.damage == 100) {
            return;
        }
        this.state = true;
        getAnimation().play();
        updateAnimation();
    }

    public void turnOff() {
        if (this.damage == 100) {
            return;
        }
        this.state = false;
        getAnimation().pause();
    }

    public boolean isRunning() {
        return this.state;
    }
    public void repairWith(Hammer hammer) {
        if (hammer == null) {
            return;
        }

        //repair only if damage > 0
        if(this.damage == 0 || this.damage == 100) {
            return;
        }
        hammer.use();

        this.damage = this.damage - 50;
        this.temperature = 0;
        updateAnimation();
        if (this.damage < 0) {
            this.damage = 0;
        }
    }
}
