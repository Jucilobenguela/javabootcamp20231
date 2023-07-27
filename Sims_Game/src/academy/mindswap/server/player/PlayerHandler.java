package academy.mindswap.server.player;

import academy.mindswap.server.Assets.Assets;
import academy.mindswap.server.Assets.Car;
import academy.mindswap.server.Assets.House.House;
import academy.mindswap.server.activity.Eat;
import academy.mindswap.server.activity.Gym;
import academy.mindswap.server.activity.Sleep;
import academy.mindswap.server.activity.Work;
import academy.mindswap.util.Messages;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerHandler implements Runnable {
    private boolean isHasHouse;
    private String name;
    private final Socket playerSocket;
    private final BufferedWriter out;
    private String message;
    private final Scanner in;
    private boolean isGameOn;
    private boolean hasMessageToRead;
    private List<Assets> assetsList;
    private int levelLife;
    private int money;

    public PlayerHandler(Socket playerSocket) throws IOException {
        this.playerSocket = playerSocket;
        this.assetsList = new ArrayList<>();
        this.out = new BufferedWriter(new OutputStreamWriter(playerSocket.getOutputStream()));
        this.in = new Scanner(playerSocket.getInputStream());
        this.levelLife = 100;
        this.money = 1000;
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
            send(Messages.NO_MONEY);
            return;
        }
        if (isHasHouse) {
            send(Messages.BUY_HOUSE_ERR);
            return;
        }
        isHasHouse = true;
        assetsList.add(house);
        send(Messages.BUY_HOUSE);
    }

    public void addName() {
        try {
            out.write(Messages.NAME_PLAYER);
            out.newLine();
            out.flush();
            name = in.next();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isCommand(String message) {
        return message.startsWith("/");
    }

    public void send(String message) {
        try {
            out.write(message);
            out.newLine();
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            playerSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
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
        send("Nivel de vida: " + levelLife);
    }

    @Override
    public void run() {
        while (in.hasNext()) {
            message = in.nextLine();
            if (isCommand(message)) {
                hasMessageToRead = true;
            }
        }
    }

    public boolean hasMessage() {
        return hasMessageToRead;
    }

    public void setHasMessageToRead(boolean hasMessageToRead) {
        this.hasMessageToRead = hasMessageToRead;
    }

    public void printsAssents() {
        assetsList.forEach(asset -> send(asset.getClass().getSimpleName()));
    }

    public void buyCar() {
        Car car = new Car();
        if (!isHasHouse) {
            send(Messages.ERR_FIRST_HOUSE);
            return;
        }
        if (money < car.getPrice()) {
            send(Messages.NO_MONEY);
            return;
        }
        assetsList.add(car);
        levelLife = car.tirednessLevel(levelLife);
        money = money - car.getPrice();
    }

    public void eat() {
        Eat eat = new Eat();
        levelLife = eat.eat();
    }
    public void work() {
        Work work = new Work();
        if (!(levelLife>work.getTirednessLevel())){
            send(Messages.LIVE_LOW);
            return;
        }
        levelLife = work.tirednessLevel(levelLife);
        this.money = work.reward(money);
        send(Messages.WON_MONEY.formatted(work.getSalary()));
        printMoney();


    }

    public void goToGym() {
        Gym gym = new Gym();
        if (!(levelLife>=gym.getTirednessLevel())){
            send(Messages.LIVE_LOW);
            return;
        }
        levelLife = gym.tirednessLevel(levelLife);
        send("exercitando");
    }

    public void printMoney() {
        send("dinheiro total: " + money);
    }

    public void sleep() {
        Sleep sleep = new Sleep();
        levelLife = sleep.restLeve(levelLife);
        send("zzzzzzzz");
    }
}

