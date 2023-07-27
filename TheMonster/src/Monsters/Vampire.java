package Monsters;
import EnumMonsters.*;
import util.Messages;

public class Vampire extends Monsters{
    private final double HEALING_PROBABILITY = 0.2;
    private final int HEALING_RATE = 10;

    public Vampire(int hitPower) {
        super(hitPower, SuperNaturalType.VAMPIRE);
    }

    @Override
    public int attack() {
        if (Math.random() < HEALING_PROBABILITY) {
            bite();
        }
        return super.attack();
    }

    private void bite() {
        if (getHealth() + HEALING_RATE > 100){
            setHealth(100);
            System.out.println(Messages.VAMPIRE_BITE_FULL_HEALTH);
            return;
        }

        setHealth(getHealth() + HEALING_RATE);
        System.out.printf(Messages.VAMPIRE_BITE, getHealth());
    }
}
