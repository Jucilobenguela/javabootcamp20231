package academy.mindswap.server.game.player;

import academy.mindswap.server.command.Command;
import academy.mindswap.util.Messages;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class PlayerHandler {
    private String name;
    private final BufferedWriter out;
    private final Scanner in;
    private boolean hasMessageToRead;
    private boolean isGameOn;

    public PlayerHandler(Socket playerSocket) throws IOException {
        this.out = new BufferedWriter(new OutputStreamWriter(playerSocket.getOutputStream()));
        this.in = new Scanner(playerSocket.getInputStream());
    }
    public void addName() {
            send(Messages.NAME_PLAYER);
            name = in.next();
    }
    public boolean hasNext(){
        return in.hasNext();
    }
    public String nextLine(){
        return in.next();
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
    public void send(List<String> messages) {
            for (String message: messages )
                if (!message.equals(Command.NOT_FOUND.getDescription())){
                    send(message);
                }
    }

  public void close(Socket playerSocket) {
        try {
            playerSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }


    public void setGameOn() {
        this.isGameOn = true;
    }
    public boolean hasMessage() {
        return hasMessageToRead;
    }

    public void setHasMessageToRead(boolean hasMessageToRead) {
        this.hasMessageToRead = hasMessageToRead;
    }

}

