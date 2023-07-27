package EnumMonsters;

public enum EnumTypeMonsters {
    WEREWOLF(1),
    VAMPIRE(2),
    MUMMY(3);
    private int idMonster;

    private EnumTypeMonsters(int idMonster){
        this.idMonster = idMonster;
    }
    public int getIdMonster(){
        return this.idMonster;
    }
}
