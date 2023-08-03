package academy.mindswap.server.command;

import academy.mindswap.server.activity.Sleep;
import academy.mindswap.server.game.SimGame;
import academy.mindswap.server.game.player.SimPlayer;
import academy.mindswap.util.Messages;

public class CommandSleep implements CommandHandler {
    @Override
    public void execute(SimGame game, SimPlayer simPlayer) {
        Sleep sleep = new Sleep();
        if (!simPlayer.isAwakeUp()){
            simPlayer.send(Messages.PLAYER_SLEEPING);
            return;
        }
        if(!simPlayer.hasHouse()){
            simPlayer.send(Messages.ERR_FIRST_HOUSE);
            return;
        }
        if(!simPlayer.getIsInGym() && !simPlayer.getIsEat()) {
            simPlayer.sleep(sleep);
        }
    }
}
