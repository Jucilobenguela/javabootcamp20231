package Game;
import Monsters.*;
import EnumMonsters.*;
import util.Messages;

public class Game  {

    private final double OBSTACLE_GENERATION_PROBABILITY = 0.3;
    private final Player player1;
    private final Player player2;
    private boolean isGameFinished;
    private boolean generatingObstacle;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        generatingObstacle = false;
    }

    public void start(int monstersPerPlayer) {

        System.out.printf(Messages.PLAYER_PICKING, player1.getName());
        player1.createMonsters(monstersPerPlayer);

        System.out.printf(Messages.PLAYER_PICKING, player2.getName());
        player2.createMonsters(monstersPerPlayer);

        System.out.println(Messages.START);

        while (!isGameFinished) {

            if (generatingObstacle == isGameGeneratingObstacle()) {
                isGameFinished = playerOnObstacleAttack();
                continue;
            }

            isGameFinished = playerOnPlayerAttack();
        }
    }

    private boolean playerOnObstacleAttack() {
        SuperNatural superNatural = generateObstacle();

        System.out.printf(Messages.GAME_OBJECT, superNatural.getType());

        player1.suffer(superNatural.getHitPower());
        player2.suffer(superNatural.getHitPower());

        if (checkPlayerLoss(player1) || checkPlayerLoss(player2)) {
            return true;
        }

        if (superNatural instanceof Strikeable) {
            ((Strikeable) superNatural).suffer(player1.attack());
            ((Strikeable) superNatural).suffer(player2.attack());
        }

        return false;
    }

    private boolean checkPlayerLoss(Player player) {
        if (player.isDead()) {
            System.out.printf(Messages.LOSE, player.getName());
            return true;
        }
        return false;
    }

    private SuperNatural generateObstacle() {

        ObstaclesTypes obstacle = ObstaclesTypes.values()[(int) (Math.random() * ObstaclesTypes.values().length)];
        return SuperNaturalsFactory.create(obstacle.getSuperNaturalType());

    }

    private boolean playerOnPlayerAttack() {


        Player firstToDefend = Math.random() > 0.5 ? player1 : player2;
        Player secondToDefend = player1 == firstToDefend ? player2 : player1;

        playerDefendAttack(firstToDefend, secondToDefend);
        if (checkPlayerLoss(firstToDefend)) {
            return true;
        }

        playerDefendAttack(secondToDefend, firstToDefend);
        if (checkPlayerLoss(secondToDefend)) {
            return true;
        }

        System.out.println(Messages.NEXT_ROUND);
        return false;
    }

    private void playerDefendAttack(Player defender, Player attacker){
        System.out.printf(Messages.HIT, defender.getName());
        defender.suffer(attacker.attack());
    }

    private boolean isGameGeneratingObstacle() {
        return Math.random() < OBSTACLE_GENERATION_PROBABILITY;
    }
}
