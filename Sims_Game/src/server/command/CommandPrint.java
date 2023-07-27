package server.command;

import server.game.SimGame;
import server.player.PlayerHandler;

public class CommandPrint implements CommandHandler {
    @Override
    public void execute(SimGame game, PlayerHandler playerHandler) {
        playerHandler.send(Command.Description().toString());
    }
}
