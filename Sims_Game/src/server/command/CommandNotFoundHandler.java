package server.command;

import server.game.SimGame;
import server.player.PlayerHandler;
import util.Messages;

public class CommandNotFoundHandler implements CommandHandler {
    public void execute(SimGame SimGame, PlayerHandler playerHandler) {
        playerHandler.send(Messages.NO_SUCH_COMMAND);
    }

}
