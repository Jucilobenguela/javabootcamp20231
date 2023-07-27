package academy.mindswap.server.game;
import academy.mindswap.server.command.Command;
import academy.mindswap.exception.PlayerConnectionDownException;
import academy.mindswap.server.player.PlayerHandler;
import academy.mindswap.util.Messages;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SimGame implements Runnable {

    private final List<PlayerHandler> playerHandlers;
    private boolean isGameStarted;
    public SimGame() {
        playerHandlers = new CopyOnWriteArrayList<>();
    }
    @Override
    public void run() {
        playerHandlers.forEach(playerHandler -> new Thread(playerHandler).start());
        isGameStarted = true;
        playerHandlers.forEach(PlayerHandler::setGameOn);
        broadcast(Messages.GAME_STARTED_MESSAGE);
        while (isGameStarted) {
            playerHandlers.forEach(
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
    private void receivePlayerInput(PlayerHandler playerHandler) throws PlayerConnectionDownException {
        String reply;
        while (playerHandler.hasMessage()) {
            reply = playerHandler.getMessage();
            System.out.println(Messages.PLAYER_INPUT_TO_SERVER + playerHandler.getName() + " "  +  reply);
            try {
                dealWithCommand(playerHandler.getMessage(), playerHandler);
            } catch (PlayerConnectionDownException e) {
                throw new PlayerConnectionDownException(Messages.CLIENT_ERROR);
            }
            playerHandler.setHasMessageToRead(false);
        }
    }

    private void dealWithCommand(String message, PlayerHandler playerHandler) throws PlayerConnectionDownException {
        String description = message.split(" ")[0];
        Command command = Command.getCommandFromDescription(description);

        if (command == null) {
            command = Command.NOT_FOUND;
        }

        if (playerHandler != null) {
            command.getHandler().execute(this, playerHandler);
        } else {
            command.getHandler().execute(this, null);
        }
    }
    public void isGameStar(boolean gameStarted) {
        isGameStarted = gameStarted;
    }
    public void broadcast(String message) {
        playerHandlers
                .forEach(handler -> handler.send(message));
    }
    public void addPlayer(PlayerHandler playerHandler) {
        playerHandlers.add(playerHandler);
        playerHandler.send(Messages.WELCOME.formatted(playerHandler.getName()));
        playerHandler.send(Command.Description().toString());
    }
}


