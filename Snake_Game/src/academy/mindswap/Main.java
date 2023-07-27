package academy.mindswap;

public class Main {
    //position, snake, direction, fruit

    public static void main(String[] args) {
       Game game = new Game(100, 25, 90);
        try {
            game.start();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
