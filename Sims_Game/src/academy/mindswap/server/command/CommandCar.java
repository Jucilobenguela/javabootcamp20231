package academy.mindswap.server.command;


import academy.mindswap.server.game.SimGame;
import academy.mindswap.server.player.SimPlayer;

public class CommandCar implements CommandHandler {
    @Override
    public void execute(SimGame game, SimPlayer simPlayer) {
            simPlayer.buyCar();
    }
}
