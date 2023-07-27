package server.Assets.House;

import java.util.Scanner;

public class Room {
    Scanner scanner = new Scanner(System.in);
    private int idRoom;
    private int statusCleaning;

    public Room(int idRoom) {
        this.idRoom = idRoom;
        this.statusCleaning = 100;
    }
    public int getIdRoom() {
        return idRoom;
    }

    public int getStatusCleaning() {
        return statusCleaning;
    }

    public void setStatusCleaning(int statusCleaning) {
        this.statusCleaning = statusCleaning;
    }

}
