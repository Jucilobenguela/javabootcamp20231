package academy.mindswap.server.command;

import academy.mindswap.server.game.SimGame;
import academy.mindswap.server.game.player.SimPlayer;

public class CommandStatistic implements CommandHandler {
    @Override
    public void execute(SimGame game, SimPlayer simPlayer) {
        simPlayer.printMoney();
        simPlayer.printLevelLife();
    }
}
