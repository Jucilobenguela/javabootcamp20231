package academy.mindswap.server;
import academy.mindswap.server.game.SimGame;
import academy.mindswap.server.player.SimPlayer;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Server {
    private ServerSocket serverSocket;
    private final ExecutorService service;
    private final SimGame simGame;
    public Server() {
        simGame = new SimGame();
        service = Executors.newCachedThreadPool();
    }
    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.print("jogo iniciado "+ port);
        System.out.println();
        while (true) {
            acceptConnection();
        }
    }
    public void acceptConnection() throws IOException {
        Socket clientSocket = serverSocket.accept();
        SimPlayer simPlayer = new SimPlayer(clientSocket);
        simPlayer.addName();
        addPlayerToGame(simGame, simPlayer);
        startGameInstance(simGame);
    }
    private void addPlayerToGame(SimGame simGame, SimPlayer simPlayer) {
        if (simGame != null) {
            simGame.addPlayer(simPlayer);
        }
    }
    private void startGameInstance(SimGame simGame) {
        service.submit(simGame);
    }
}