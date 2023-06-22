package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Computer extends AbstractActor {
    public Computer() {
        Animation computer = new Animation(
            "sprites/computer.png",
            80,
            48,
            0.5f, Animation.PlayMode.LOOP_PINGPONG);
        setAnimation(computer);
    }
    public int add(int prveCislo, int druheCislo) {
        int sucet = prveCislo + druheCislo;
        return sucet;
    }

    public int sub(int prveCislo, int druheCislo) {
        int rozdiel = prveCislo - druheCislo;
        return rozdiel;
    }



}
