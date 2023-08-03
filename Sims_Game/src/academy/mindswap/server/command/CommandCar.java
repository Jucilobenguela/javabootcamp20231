package academy.mindswap.server.command;


import academy.mindswap.server.Assets.Car;
import academy.mindswap.server.game.SimGame;
import academy.mindswap.server.game.player.SimPlayer;
import academy.mindswap.util.Messages;

public class CommandCar implements CommandHandler {
    @Override
    public void execute(SimGame game, SimPlayer simPlayer) {
        Car car = new Car();
        if (!simPlayer.getIsHasHouse()) {
            simPlayer.send(Messages.ERR_FIRST_HOUSE);
            return;
        }
        if (simPlayer.getMoney() < car.getPrice()) {
            simPlayer.send(Messages.NO_MONEY);
            return;
        }
        simPlayer.buyCar(car);
    }
}
