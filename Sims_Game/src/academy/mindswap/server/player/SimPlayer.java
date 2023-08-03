package academy.mindswap.server.player;

import academy.mindswap.server.Assets.Assets;
import academy.mindswap.server.Assets.Car;
import academy.mindswap.server.Assets.House.House;
import academy.mindswap.server.activity.Eat;
import academy.mindswap.server.activity.Gym;
import academy.mindswap.server.activity.Sleep;
import academy.mindswap.server.activity.Work;
import academy.mindswap.util.Messages;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SimPlayer implements Runnable {
    PlayerHandler playerHandler;
    private boolean isHasHouse;
    private boolean isAwakeUp;
    private boolean isGameOn;
    private final Socket socket;
    private String message;
    private List<Assets> assetsList;
    private int levelLife;
    private int money;

    public SimPlayer(Socket playerSocket) throws IOException {
        this.socket = playerSocket;
        this.playerHandler = new PlayerHandler(playerSocket);
        this.assetsList = new ArrayList<>();
       this.levelLife = 100;
        this.money = 1000;
        this.isAwakeUp=true;
        this.isHasHouse=false;
    }
    public boolean hasHouse() {
        if (isHasHouse == true) {
            return true;
        }
        return false;
    }

    public void buyHouse() {
        House house = new House();
        if (money <house.priceHouse()) {
            playerHandler.send(Messages.NO_MONEY);
            return;
        }
        if (isHasHouse) {
            playerHandler.send(Messages.BUY_HOUSE_ERR);
            return;
        }
        isHasHouse = true;
        assetsList.add(house);
        playerHandler.send(Messages.BUY_HOUSE);
    }

    private boolean isCommand(String message) {
        return message.startsWith("/");
    }

    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return playerHandler.getName();
    }

    public String getMessage() {
        return message;
    }

    public void setGameOn() {
        isGameOn = true;
    }

    public int getMoney() {
        return money;
    }

    public void printLevelLife() {

        playerHandler.send("Nivel de vida: " + levelLife);
    }

    @Override
    public void run() {
        while (playerHandler.hasNext()) {
            message = playerHandler.nextLine();
            if (isCommand(message)) {
                playerHandler.setHasMessageToRead(true);
            }
        }
    }
    public void printsAssents() {
        assetsList.forEach(asset -> playerHandler.send(asset.getClass().getSimpleName()));
    }
    public void buyCar() {
        Car car = new Car();
        if (!isHasHouse) {
            playerHandler.send(Messages.ERR_FIRST_HOUSE);
            return;
        }
        if (money < car.getPrice()) {
            playerHandler.send(Messages.NO_MONEY);
            return;
        }
        assetsList.add(car);
        levelLife = car.tirednessLevel(levelLife);
        money = money - car.getPrice();
    }

    public void eat() {
        Eat eat = new Eat();
        this.levelLife = eat.eat();
        playerHandler.send("comeu");
    }
    public void work(Work work) {
        levelLife = work.tirednessLevel(levelLife);
        this.money = work.reward(money);
        playerHandler.send(Messages.WON_MONEY.formatted(work.getSalary()));
        printMoney();
    }
    public void goToGym(Gym gym) {
        levelLife = gym.tirednessLevel(levelLife);
        playerHandler.send("exercitando");
    }
    public void printMoney() {
        playerHandler.send("dinheiro total: " + money);
    }
    public void sleep(Sleep sleep) {
        levelLife = sleep.restLeve(levelLife);
        playerHandler.send("zzzzzzzz");
        isAwakeUp=false;
    }
    public int getLevelLife() {
        return levelLife;
    }
    public boolean isAwakeUp(){
        if(!isAwakeUp){
            return false;
        }
        return true;
    }
    public void wakeUp()
    {
        isAwakeUp=true;
    }
    public void addName(){
        playerHandler.addName();
    }
    public void send(String message){
        playerHandler.send(message);
    }
    public void send(List<String> message){
        playerHandler.send(message);
    }

    public boolean hasMessage() {
        return playerHandler.hasMessage();
    }

    public void setHasMessageToRead(boolean bool) {
        playerHandler.setHasMessageToRead(bool);
    }
}

