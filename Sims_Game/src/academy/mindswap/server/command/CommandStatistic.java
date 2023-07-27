package academy.mindswap.server.command;

import academy.mindswap.server.game.SimGame;
import academy.mindswap.server.player.PlayerHandler;

public class CommandStatistic implements CommandHandler {
    @Override
    public void execute(SimGame game, PlayerHandler playerHandler) {
        playerHandler.printMoney();
        playerHandler.printLevelLife();
    }
}
