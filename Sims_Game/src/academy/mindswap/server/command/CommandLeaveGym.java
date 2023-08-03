package academy.mindswap.server.command;

import academy.mindswap.server.game.SimGame;
import academy.mindswap.server.game.player.SimPlayer;
import academy.mindswap.util.Messages;

public class CommandLeaveGym implements CommandHandler {
    @Override
    public void execute(SimGame game, SimPlayer simPlayer) {
        if (simPlayer.getIsInGym()) {
            simPlayer.leaveTheGym();
            simPlayer.send(Messages.LEFT_GYM);
        }
    }
}
