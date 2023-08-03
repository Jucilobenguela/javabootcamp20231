package academy.mindswap.server.command;

import academy.mindswap.server.game.SimGame;
import academy.mindswap.server.player.SimPlayer;

public class CommandHouse implements CommandHandler {
    @Override
    public void execute(SimGame game, SimPlayer simPlayer) {
        simPlayer.buyHouse();

    }
}
