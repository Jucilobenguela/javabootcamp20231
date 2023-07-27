package Monsters;
import EnumMonsters.*;
import util.*;

public class SuperNatural {
    private SuperNaturalType type;
    private int hitPower;
    private int health;
    protected int changeMe;

    public SuperNatural(int hitPower, SuperNaturalType type) {
        this.hitPower = hitPower;
        this.health = 100;
        this.type = type;
    }

    public int attack() {
        System.out.printf(Messages.MONSTER_ATTACK, this);
        return hitPower;
    }

    public int getHealth() {
        return health;
    }

    public int getHitPower() {
        return hitPower;
    }

    public SuperNaturalType getType() {
        return type;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return getType().getDescription();
    }
}
