package academy.mindswap.server.command;


import academy.mindswap.server.game.SimGame;
import academy.mindswap.server.player.PlayerHandler;

public class CommandCar implements CommandHandler {
    @Override
    public void execute(SimGame game, PlayerHandler playerHandler) {
            playerHandler.buyCar();
    }
}
