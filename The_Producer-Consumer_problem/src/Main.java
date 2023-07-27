// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant(5);

        Thread cookTread = new Thread(new Cook(restaurant));
        Thread clientTHread = new Thread(new Client(restaurant));


        cookTread.start();
        clientTHread.start();

    }
}