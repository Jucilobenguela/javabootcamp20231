package Game;


import Monsters.*;
import EnumMonsters.*;
import util.*;

public class Player {
    private String name;
    private Monsters[] monsters;
    private boolean lost;

    public Player(String name) {
        this.name = name;
    }

    public void createMonsters(int monstersPerPlayer) {
        monsters = new Monsters[monstersPerPlayer];
        SuperNatural superNatural;

        for (int i = 0; i < monsters.length; i++) {
            superNatural = generateSuperNaturalBeing();

            while (!(superNatural instanceof Monsters)) {
                superNatural = generateSuperNaturalBeing();
            }
            monsters[i] = (Monsters) superNatural;
            System.out.printf(Messages.MONSTER_CREATION, name, monsters[i]);
        }
    }

    private SuperNatural generateSuperNaturalBeing() {
        return SuperNaturalsFactory.create(SuperNaturalType.values()[(int) (Math.random() * SuperNaturalType.values().length)]);
    }

    public int attack() {
        Monsters monster = chooseMonster();

        System.out.printf(Messages.MONSTER_CHOICE, name, monster, "attack");
        return monster.attack();
    }


    public void suffer(int damage) {
        Monsters monster = chooseMonster();
        System.out.printf(Messages.MONSTER_CHOICE, name, monster, "defend");
        monster.suffer(damage);
        if (checkDeadMonsters() == monsters.length) {
            die();
        }

    }

    private Monsters chooseMonster() {
        Monsters monster = monsters[RandomGenerator.generateRandom(0, monsters.length - 1)];

        if (monster.isDead()) {
            monster = chooseMonster(); // RECURSION
        }

        return monster;
    }

    private int checkDeadMonsters() {
        int deadMonsters = 0;

        for (Monsters monster : monsters) {
            deadMonsters = monster.isDead() ? deadMonsters + 1 : deadMonsters;
        }

        System.out.printf(Messages.DEAD_MONSTER_AMOUNT, name, deadMonsters);
        return deadMonsters;
    }


    public String getName() {
        return this.name;
    }



    public void die() {
        lost = true;
    }


    public boolean isDead() {
        return lost;
    }
}

