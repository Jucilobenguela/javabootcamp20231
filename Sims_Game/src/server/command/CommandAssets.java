package server.command;

import server.game.SimGame;
import server.player.PlayerHandler;

public class CommandAssets implements CommandHandler {
    @Override
    public void execute(SimGame game, PlayerHandler playerHandler) {
        if (!playerHandler.hasHouse()) {
            playerHandler.send("comprar primeiramente uma casa");
            return;
        }
        playerHandler.printsAssents();
    }
}
