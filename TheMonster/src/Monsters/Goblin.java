package Monsters;
import EnumMonsters.*;
import util.Messages;

public class Goblin extends SuperNatural implements Strikeable {

        private boolean dead;

        public Goblin(int hitPower) {
            super(hitPower, SuperNaturalType.GOBLIN);
        }

        @Override
        public void suffer(int amount) {
            if (getHealth() - amount  <= 0) {
                setHealth(0);
                die();
                System.out.printf(Messages.DEAD_SUPERNATURAL, this);
                return;
            }

            setHealth(getHealth() - amount );
            System.out.printf(Messages.SUPERNATURAL_SUFFER, this, amount, getHealth());
        }

        @Override
        public void die() {
            dead = true;
        }

        @Override
        public boolean isDead() {
            return dead;
        }
    }

