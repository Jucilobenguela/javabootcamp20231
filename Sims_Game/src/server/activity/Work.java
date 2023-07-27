package server.activity;

public class Work {
    private final int salary = 1000;
    private final int tirednessLevel = 90;
    public int reward(int money){
        return money + salary;
    }
    public int getSalary(){
        return salary;
    }
    public int tirednessLevel(int levelLife){
        return levelLife-tirednessLevel;
    }

    public int getTirednessLevel() {
        return tirednessLevel;
    }
}
