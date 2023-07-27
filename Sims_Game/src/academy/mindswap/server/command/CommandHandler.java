package academy.mindswap.server.command;


import academy.mindswap.server.game.SimGame;
import academy.mindswap.server.player.PlayerHandler;

public interface CommandHandler {
    void execute(SimGame game, PlayerHandler playerHandler);
}

