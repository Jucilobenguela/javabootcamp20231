public enum CardList {
    DEBIT(1, "Debit Card"),
    CREDIT(2, "Credit Card"),
    DEBITANDCREDIT(3,"Debit Card and Credit Card");

    private int idcard;
    private String nameCard;

    private CardList(int id, String name)
    {
        idcard=id;
        nameCard=name;
    }
    public int getIdCard()
    {
       return idcard;
    }
    public String getNameCard() {
        return nameCard;
    }
}
