package academy.mindswap.server.command;


import academy.mindswap.server.game.SimGame;
import academy.mindswap.server.player.SimPlayer;

public class CommandAssets implements CommandHandler {
    @Override
    public void execute(SimGame game, SimPlayer simPlayer) {
        if (!simPlayer.hasHouse()) {
            simPlayer.send("comprar primeiramente uma casa");
            return;
        }
        simPlayer.printsAssents();
    }
}
