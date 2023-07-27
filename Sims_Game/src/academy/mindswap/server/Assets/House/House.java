package academy.mindswap.server.Assets.House;

import academy.mindswap.server.Assets.Assets;

import java.util.Scanner;

public class House implements Assets {
    private Scanner scanner = new Scanner(System.in);
    private Room[] rooms;
    private final int priceHouse;

    public House() {
       // this.rooms = rooms;
        this.priceHouse = 2000;
    }

    public boolean roomOccupied() {
        if (rooms[rooms.length - 1] == null) {
            return false;
        }
        return true;
    }

    public void useHouse() {
        scanner.next();
        // Room room = new Room()

    }

    public void addRoomsHouse(Room room) {
        int nextPosition = -1;
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] == null) {
                nextPosition = i;
                break;
            }
        }
        if (nextPosition != -1) {
            rooms[nextPosition] = room;
        } else {
            System.out.println("There is no more room to add to thr house!");
        }
        System.out.println(rooms.length);
    }

    public int priceHouse() {
        return this.priceHouse;
    }
}
