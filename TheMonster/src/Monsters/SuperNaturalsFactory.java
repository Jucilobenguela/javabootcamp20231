package Monsters;
import EnumMonsters.*;

public class SuperNaturalsFactory {
    private SuperNaturalsFactory() {

    }

    public static SuperNatural create(SuperNaturalType type) {
        switch (type) {
            case WEREWOLF:
                return new Werewolf(30);
            case MUMMY:
                return new Mummy(10);
            case WITCH:
                return new Witch(15);
            case FAIRY:
                return new Fairy(10);
            case GOBLIN:
                return new Goblin(5);
            default:
                return new Vampire(20);
        }
    }
}

