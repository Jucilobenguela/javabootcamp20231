package server.command;

import server.game.SimGame;
import server.player.PlayerHandler;


public interface CommandHandler {
    void execute(SimGame game, PlayerHandler playerHandler);
}

