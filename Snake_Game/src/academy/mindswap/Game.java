package academy.mindswap;

import academy.mindswap.field.Field;
import academy.mindswap.field.Position;
import academy.mindswap.gameobjects.fruit.Fruit;
import academy.mindswap.gameobjects.snake.Direction;
import academy.mindswap.gameobjects.snake.Snake;
import com.googlecode.lanterna.input.Key;

import java.util.LinkedList;
import java.util.Random;


public class Game {

    private Snake snake;
    private Fruit fruit;
    private int delay;
   // private LinkedList<Fruit> fruits;

    public Game(int cols, int rows, int delay) {
        Field.init(cols, rows);
        snake = new Snake(new Position(20, 20));
        this.delay = delay;
    }

    public void start() throws InterruptedException {


        generateFruit(); // uncomment when it's time to introduce fruits

        while (snake.isAlive()) {
            Thread.sleep(delay);
            Field.clearTail(snake);
            moveSnake();
            checkCollisions();
            Field.drawSnake(snake);
        }


    }

    private void generateFruit() {
        Random random = new Random();
        int row = random.nextInt(1,Field.getHeight()-1);
        int col = random.nextInt(1,Field.getWidth() -1);
        fruit = new Fruit(new Position(row, col));
        Field.drawFruit(fruit);
    }

    //responsável por ler a entrada do usuário e mover a cobra (snake) na direção correspondente com base na tecla pressionada.
    private void moveSnake() {

        Key k = Field.readInput();

        if (k != null) {
            switch (k.getKind()) {
                case ArrowUp:
                    snake.move(Direction.UP);
                    return;

                case ArrowDown:
                    snake.move(Direction.DOWN);
                    return;

                case ArrowLeft:
                    snake.move(Direction.LEFT);
                    return;

                case ArrowRight:
                    snake.move(Direction.RIGHT);
                    return;
            }
        }
        snake.move();
    }
    private void checkCollisions() {
        if(snake.getHead().getRow()==fruit.getPosition().getRow()
                && snake.getHead().getCol()==fruit.getPosition().getCol()){
            fruit = null;
            snake.increaseSize();
            generateFruit();

           return;
        }
        // Verificar colisão com os limites do campo de jogo
        Position head  = snake.getHead();
        if (head.getRow() < 1 ||
                head.getRow() >= Field.getHeight()-1 ||
                head.getCol() < 1 ||
                head.getCol() >= Field.getWidth()-1) {
            snake.die(); // A cobra morre se atingir os limites do campo
            return;
        }

        // Verificar colisão com o próprio corpo da cobra
        if(snake.isHeadTouchingBody()){
            snake.die();
        }
      /*  for (int i = 0; i < snake.getSnakeSize(); i++) {
            for (int j = 0; j < snake.getSnakeSize(); j++) {
                fruits.add(new Fruit(new Position(i, j)));
                if (snake.isAlive() && !fruits.isEmpty()) {
                    Position head = snake.getHead();
                        if (fruit.equals(head)) {
                            // A cobra come a fruta e aumenta de tamanho
                            snake.increaseSize();
                            generateFruit();
                        }
                }
            }
        }*/
    }

}
