package server.command;

import server.game.SimGame;
import server.player.PlayerHandler;

public class CommandWork implements CommandHandler {
    @Override
    public void execute(SimGame game, PlayerHandler playerHandler) {
        playerHandler.work();
    }
}
