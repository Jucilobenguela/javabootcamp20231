public enum EnumVehicles {
    VW(1),
    MERCEDES(2),
    CITROEN(3),
    HONDA(4),
    VOGE(5),
    MOTOGUZZI(6);
    private int value;
    private EnumVehicles(int value){
        this.value=value;
    }

    public int getValue() {
        return value;
    }
}
