package academy.mindswap.server.command;

import academy.mindswap.server.activity.Eat;
import academy.mindswap.server.game.SimGame;
import academy.mindswap.server.game.player.SimPlayer;

public class CommandoEat implements CommandHandler {
    @Override
    public void execute(SimGame game, SimPlayer simPlayer) {
        Eat eat = new Eat();
        simPlayer.eat(eat);
    }
}
