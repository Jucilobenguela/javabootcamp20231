package server.command;

import server.game.SimGame;
import server.player.PlayerHandler;

public class CommandoEat implements CommandHandler {
    @Override
    public void execute(SimGame game, PlayerHandler playerHandler) {
        playerHandler.eat();
    }
}
