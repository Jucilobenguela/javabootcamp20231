package academy.mindswap.server.command;


import academy.mindswap.server.activity.Gym;
import academy.mindswap.server.game.SimGame;
import academy.mindswap.server.game.player.SimPlayer;
import academy.mindswap.util.Messages;

public class CommandGym implements CommandHandler {
    @Override
    public void execute(SimGame game, SimPlayer simPlayer)
    {
        Gym gym = new Gym();
        if (!(simPlayer.getLevelLife()>=gym.getTirednessLevel())){
            simPlayer.send(Messages.LIVE_LOW);
            return;
        }
        if (!simPlayer.isAwakeUp()){
            simPlayer.send(Messages.PLAYER_SLEEPING);
            return;
        }
        if (!simPlayer.getIsEat()){
            simPlayer.goToGym(gym);
        }
    }
}
