package academy.mindswap.server.command;


import academy.mindswap.server.activity.Work;
import academy.mindswap.server.game.SimGame;
import academy.mindswap.server.player.SimPlayer;
import academy.mindswap.util.Messages;

public class CommandWork implements CommandHandler {
    @Override
    public void execute(SimGame game, SimPlayer simPlayer) {
        Work work = new Work();
        if (!simPlayer.isAwakeUp()){
            simPlayer.send(Messages.PLAYER_SLEEPING);
            return;
        }
        if (!(simPlayer.getLevelLife()>work.getTirednessLevel())){
            simPlayer.send(Messages.LIVE_LOW);
            return;
        }
        simPlayer.work(work);
    }
}
