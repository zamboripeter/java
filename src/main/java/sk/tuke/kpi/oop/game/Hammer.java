package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Hammer extends AbstractActor {
    private int usages;
    public Hammer() {
        this.usages =1;
        Animation animation = new Animation("sprites/hammer.png");
        setAnimation(animation);
    }

    public int getUsages() {
        return this.usages;
    }

    public void use() {
        this.usages -= 1;

        if (this.usages == 0) {
            this.getScene().removeActor(this);
        }

    }
}
