package academy.mindswap.server.command;

import academy.mindswap.server.game.SimGame;
import academy.mindswap.server.game.player.SimPlayer;
import academy.mindswap.util.Messages;

public class CommandFinishEating implements CommandHandler {
    @Override
    public void execute(SimGame game, SimPlayer simPlayer) {
        if (simPlayer.getIsEat()){
            simPlayer.finishEating();
            simPlayer.send(Messages.FINISH_EATING);
        }
    }
}
