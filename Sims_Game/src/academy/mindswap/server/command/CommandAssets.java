package academy.mindswap.server.command;


import academy.mindswap.server.game.SimGame;
import academy.mindswap.server.game.player.SimPlayer;
import academy.mindswap.util.Messages;

public class CommandAssets implements CommandHandler {
    @Override
    public void execute(SimGame game, SimPlayer simPlayer) {
        if (!simPlayer.hasHouse()) {
            simPlayer.send(Messages.ERR_FIRST_HOUSE);
            return;
        }
        simPlayer.printsAssents();
    }
}
