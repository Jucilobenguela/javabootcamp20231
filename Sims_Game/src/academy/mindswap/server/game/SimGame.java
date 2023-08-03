package academy.mindswap.server.game;
import academy.mindswap.server.command.Command;
import academy.mindswap.exception.PlayerConnectionDownException;
import academy.mindswap.server.game.player.SimPlayer;
import academy.mindswap.util.Messages;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SimGame implements Runnable {

    private final List<SimPlayer> simPlayers;
    private boolean isGameStarted;
    public SimGame()
    {
        simPlayers = new CopyOnWriteArrayList<>();
    }
    @Override
    public void run() {
        simPlayers.forEach(simPlayer -> new Thread(simPlayer).start());
        isGameStarted = true;
        simPlayers.forEach(SimPlayer::setGameOn);
        broadcast(Messages.GAME_STARTED_MESSAGE);
        while (isGameStarted) {
            simPlayers.forEach(
                    playerHandler -> {
                        try {
                            receivePlayerInput(playerHandler);
                        } catch (PlayerConnectionDownException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
        }
    }
    private void receivePlayerInput(SimPlayer simPlayer) throws PlayerConnectionDownException {
        String reply;
        while (simPlayer.hasMessage()) {
            reply = simPlayer.getMessage();
            System.out.println(Messages.PLAYER_INPUT_TO_SERVER + simPlayer.getName() + " "  +  reply);
            try {
                dealWithCommand(simPlayer.getMessage(), simPlayer);
            } catch (PlayerConnectionDownException e) {
                throw new PlayerConnectionDownException(Messages.CLIENT_ERROR);
            }
            simPlayer.setHasMessageToRead(false);
        }
    }

    private void dealWithCommand(String message, SimPlayer simPlayer) throws PlayerConnectionDownException {
        String description = message.split(" ")[0];
        Command command = Command.getCommandFromDescription(description);

        if (command == null) {
            command = Command.NOT_FOUND;
        }

        if (simPlayer != null) {
            command.getHandler().execute(this, simPlayer);
        } else {
            command.getHandler().execute(this, null);
        }
    }
    public void isGameStar(boolean gameStarted) {
        isGameStarted = gameStarted;
    }
    public void broadcast(String message) {
        simPlayers
                .forEach(handler -> handler.send(message));
    }
    public void addPlayer(SimPlayer simPlayer) {
        simPlayers.add(simPlayer);
        simPlayer.send(Messages.WELCOME.formatted(simPlayer.getName()));
        simPlayer.send(Command.Description());
    }
}


