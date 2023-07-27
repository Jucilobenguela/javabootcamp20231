package Monsters;
import EnumMonsters.*;
import util.Messages;

public class Witch extends SuperNatural implements Strikeable {

    private boolean dead;

    public Witch(int hitPower) {
        super(hitPower, SuperNaturalType.WITCH);
    }

    @Override
    public void suffer(int amount) {
        if (getHealth() - (amount / 2) <= 0) {
            setHealth(0);
            die();
            System.out.printf(Messages.DEAD_SUPERNATURAL, this);
            return;
        }

        setHealth(getHealth() - (amount / 2));
        System.out.printf(Messages.SUPERNATURAL_SUFFER, this, amount, getHealth());
    }

    @Override
    public void die(){
        dead = true;
    }

    public boolean isDead() {
        return dead;
    }
}
