import Game.Game;
import Game.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Game game = new Game(new Player("Dan"), new Player("Patrick"));

        try{
            game.start(3);
            System.out.println("After error");
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
            game = new Game(new Player("ddd"),new Player("gdsfgsdfgs"));
            game.start(1);
            System.out.println("Hello!");
            //  return;
        } finally {
            System.out.println("Hello!");
        }


        System.out.println("adasdasd");



    }
}