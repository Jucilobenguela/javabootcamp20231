package academy.mindswap.server.activity;

public class Gym {
    private final  int tirednessLevel = 20;
    public int tirednessLevel(int levelLife) {
        return levelLife - tirednessLevel;
    }
    public int getTirednessLevel() {
        return tirednessLevel;
    }

}
