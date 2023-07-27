package Monsters;
import EnumMonsters.*;
import util.Messages;

public class Mummy extends Monsters{
    private final int MAXIMUM_CONSECUTIVE_HITS = 2;
    private final int UNROLL_DAMAGE = 10;
    private int consecutiveHits;

    public Mummy(int hitPower) {
        super(hitPower, SuperNaturalType.MUMMY);
    }

    @Override
    public int attack() {

        changeMe = 20;
        consecutiveHits++;

        if (consecutiveHits == MAXIMUM_CONSECUTIVE_HITS) {
            consecutiveHits = 0;
            System.out.println(Messages.MUMMY_UNROLL_PREP);
            return unroll();
        }

        return super.attack();
    }

    private int unroll() {
        setHealth(getHealth() - UNROLL_DAMAGE);
        System.out.printf(Messages.MUMMY_UNROLL, UNROLL_DAMAGE);
        return 0;
    }
    }
