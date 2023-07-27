package academy.mindswap.server.command;


import academy.mindswap.server.game.SimGame;
import academy.mindswap.server.player.PlayerHandler;
import academy.mindswap.util.Messages;

public class CommandNotFoundHandler implements CommandHandler {
    public void execute(SimGame SimGame, PlayerHandler playerHandler) {
        playerHandler.send(Messages.NO_SUCH_COMMAND);
    }

}
