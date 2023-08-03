package academy.mindswap.server.command;

import academy.mindswap.server.game.SimGame;
import academy.mindswap.server.game.player.SimPlayer;

public class QuitHandler implements CommandHandler {
    @Override
    public void execute(SimGame game, SimPlayer simPlayer) {
        simPlayer.close();
    }
}
