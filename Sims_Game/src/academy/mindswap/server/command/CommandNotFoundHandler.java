package academy.mindswap.server.command;


import academy.mindswap.server.game.SimGame;
import academy.mindswap.server.game.player.SimPlayer;
import academy.mindswap.util.Messages;

public class CommandNotFoundHandler implements CommandHandler {
    public void execute(SimGame SimGame, SimPlayer simPlayer) {
        simPlayer.send(Messages.NO_SUCH_COMMAND);
    }

}
