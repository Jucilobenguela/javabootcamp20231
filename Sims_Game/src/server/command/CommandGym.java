package server.command;

import server.game.SimGame;
import server.player.PlayerHandler;

public class CommandGym implements CommandHandler {
    @Override
    public void execute(SimGame game, PlayerHandler playerHandler) {
        playerHandler.goToGym();
    }
}