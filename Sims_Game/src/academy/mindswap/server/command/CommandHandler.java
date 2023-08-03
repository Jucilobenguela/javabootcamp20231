package academy.mindswap.server.command;


import academy.mindswap.server.game.SimGame;
import academy.mindswap.server.player.SimPlayer;

public interface CommandHandler {
    void execute(SimGame game, SimPlayer simPlayer);
}

