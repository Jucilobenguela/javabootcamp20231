package academy.mindswap.gameobjects.snake;

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;
    // verifica se a direçao é oposta a outra
    public boolean isOpposit(Direction otherDirection) {
     return this == UP && otherDirection ==DOWN ||
             this == DOWN && otherDirection == UP||
             this == LEFT && otherDirection == RIGHT||
             this == RIGHT && otherDirection == LEFT;
    }
}
