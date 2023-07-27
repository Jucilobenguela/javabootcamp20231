package academy.mindswap.gameobjects.snake;

import academy.mindswap.field.Field;
import academy.mindswap.field.Position;
import academy.mindswap.gameobjects.fruit.Fruit;

import java.util.LinkedList;

public class Snake {

    private final static int SNAKE_INITIAL_SIZE = 3;
    private Direction direction;
    private boolean alive;
    private LinkedList<Position> snakeBody;


    private Position lastTail;

    public Snake(Position initialPosition){
        this.snakeBody = new LinkedList<>();
        for (int i = 0; i < SNAKE_INITIAL_SIZE; i++) {
            snakeBody.add(new Position(initialPosition.getRow(), initialPosition.getCol()-i));
        }
        lastTail = snakeBody.getLast();
        this.alive = true;
        this.direction = Direction.RIGHT;


    }


    public void increaseSize() {
        snakeBody.addLast(new Position(getTail().getRow(), getTail().getCol()-1));
        // Obter a posição da cauda da cobra
       // Position tail = snakeBody.getLast();

        // Determinar a nova posição da cauda com base na direção atual
       // int newTailRow = tail.getRow();
       // int newTailCol = tail.getCol();

        // Adicionar uma nova posição à cauda, com base na direção atual da cobra
        /*switch (direction) {
            case UP:
                newTailRow++;
                break;
            case DOWN:
                newTailRow--;
                break;
            case LEFT:
                newTailCol++;
                break;
            case RIGHT:
                newTailCol--;
                break;
        }*/

        // Criar uma nova posição para a nova cauda da cobra
       // Position newTail = new Position(newTailRow, newTailCol);

        // Adicionar a nova cauda no final da lista da cobra
        //snakeBody.addLast(newTail);

    }

    public void move(Direction direction) {
        //impedir que a cobra iverta a posição para traz
       if (!this.direction.isOpposit(direction)){
           this.direction = direction;
        }
        // Obter a posição da cabeça da cobra
        Position head = snakeBody.getFirst();

        // Determinar a nova posição da cabeça com base na direção
        int newHeadRow = head.getRow();
        int newHeadCol = head.getCol();

        switch (this.direction) {
            case UP:
                newHeadRow--;
                break;
            case DOWN:
                newHeadRow++;
                break;
            case LEFT:
                newHeadCol--;
                break;
            case RIGHT:
                newHeadCol++;
                break;
        }

        // Criar uma nova posição para a nova cabeça da cobra
        Position newHead = new Position(newHeadRow, newHeadCol);

        // Adicionar a nova cabeça no início da lista da cobra
        snakeBody.addFirst(newHead);

        // Remover o último elemento da lista da cobra (a cauda) se a cobra não estiver crescendo
      //  if (snakeBody.size() > SNAKE_INITIAL_SIZE) {
           lastTail =  snakeBody.removeLast();
       // }
    }


    public void move(){
        move(direction);
    }

    public void die() {
        this.alive = false;
        snakeBody.removeFirst();
        snakeBody.addLast(lastTail);
    }

    public boolean isAlive() {
        return alive;
    }

    public Position getHead() {
        return snakeBody.getFirst();
    }

    public Position getTail() {
        return snakeBody.getLast();
    }

   /* public LinkedList<Position> getFullSnake(){
        return snakeBody;
    }*/
    public LinkedList<Position> getFullSnake() {
        if (snakeBody != null) {
            return snakeBody;
        } else {
            return new LinkedList<>();// Retorna uma lista vazia se snakeBody for nula
        }
    }


    public int getSnakeSize() {
        return snakeBody.size();
    }


    public boolean isHeadTouchingBody() {
        for (int i = 1; i < getFullSnake().size(); i++) {
            Position bodyPart =  snakeBody.get(i);
            if (snakeBody.getFirst().getRow()==bodyPart.getRow() && snakeBody.getFirst().getCol()==bodyPart.getCol()) {
                return true;
            }
        }
        return false;
    }
}

