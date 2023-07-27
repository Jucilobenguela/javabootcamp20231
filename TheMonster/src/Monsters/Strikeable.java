package Monsters;

public interface Strikeable {
    void suffer(int amount);
    void die();
    boolean isDead();
}

