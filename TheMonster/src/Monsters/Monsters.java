package Monsters;

import EnumMonsters.*;
import util.Messages;

public abstract class Monsters extends SuperNatural implements Strikeable {

    private boolean dead;
    String h1;

    public Monsters(int hitPower, SuperNaturalType type) {
        super(hitPower, type);
    }

    @Override
    public void suffer(int damage) {
        if (getHealth() - damage <= 0) {
            setHealth(0);
            die();
            System.out.printf(Messages.DEAD_SUPERNATURAL, this);
            return;
        }

        setHealth(getHealth() - damage);
        System.out.printf(Messages.SUPERNATURAL_SUFFER, this, damage, getHealth());
    }

    @Override
    public void die(){
        dead = true;
    }

    public boolean isDead() {
        return dead;
    }

    private void checkSomething(){
        //dummy
    }
    public void compareTo(Monsters monster){
        this.checkSomething();
        monster.checkSomething();
    }
}
