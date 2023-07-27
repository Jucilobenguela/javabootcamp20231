package server.command;

import server.game.SimGame;
import server.player.PlayerHandler;

public class CommandStatistic implements CommandHandler {
    @Override
    public void execute(SimGame game, PlayerHandler playerHandler) {
        playerHandler.printMoney();
        playerHandler.printLevelLife();
    }
}
