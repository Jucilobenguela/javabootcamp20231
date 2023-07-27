package server.command;

import server.Assets.House.House;
import server.Assets.House.Room;
import server.game.SimGame;
import server.player.PlayerHandler;

public class CommandHouse implements CommandHandler {
    @Override
    public void execute(SimGame game, PlayerHandler playerHandler) {
        playerHandler.buyHouse();

    }
}
