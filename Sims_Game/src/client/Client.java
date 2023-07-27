package client;
import server.player.PlayerHandler;
import util.Messages;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.start(Messages.LOCALHOST, 8082);
        } catch (IOException e) {
            System.out.println(Messages.CONNECTION_CLOSED);
        }

    }

    private void start(String host, int port) throws IOException {
        Socket socket = new Socket(host, port);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        new Thread(new KeyboardHandler(out, socket)).start();
        String line;

        while ((line = in.readLine()) != null) {
           /* if (line.equals(Messages.YES)) {
            }*/
            System.out.println(line);
        }
        socket.close();
    }
    private class KeyboardHandler implements Runnable {
        private BufferedWriter out;
        private Socket socket;
        private BufferedReader in;

        public KeyboardHandler(BufferedWriter out, Socket socket) {
            this.out = out;
            this.socket = socket;
            this.in = new BufferedReader(new InputStreamReader(System.in));

        }


        @Override
        public void run() {

            while (!socket.isClosed()) {
                try {
                    String line = in.readLine();
                    out.write(line);
                    out.newLine();
                    out.flush();
                    if (line == null) {
                        break;
                    }
                    if (line.equals("/quit")) {
                        socket.close();
                        System.exit(0);
                    }
                } catch (IOException e) {
                    System.out.println(Messages.SEVER_ERROR);
                    try {
                        socket.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}

