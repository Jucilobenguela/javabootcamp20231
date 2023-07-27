package server.Assets;

public class Car implements Assets {
    private final int price = 1000;

    public int tirednessLevel(int levelLife){
        return levelLife-2;
    }

    public int getPrice() {
        return price;
    }
}
