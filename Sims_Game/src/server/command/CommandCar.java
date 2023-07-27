package server.command;

import server.Assets.Car;
import server.game.SimGame;
import server.player.PlayerHandler;

public class CommandCar implements CommandHandler {
    @Override
    public void execute(SimGame game, PlayerHandler playerHandler) {
            playerHandler.buyCar();
    }
}
