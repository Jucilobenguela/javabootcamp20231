public class Client {
    private Integer clientNumber;
    private int cardAmount;
    private String holder;
    Account accounts;


    public Client(int cardAmount, Integer clientNumber, String holder, Account accounts) {
        this.cardAmount = cardAmount;
        this.holder = holder;
        this.accounts=accounts;

    }

    public Integer getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(Integer clientNumber) {
        this.clientNumber = clientNumber;
    }

    public int getCardAmount() {
        return cardAmount;
    }

    public void setCardAmount(int cardAmount) {
        this.cardAmount = cardAmount;
    }

    public Account getAccounts() {
        return accounts;
    }

    public void setAccounts(Account accounts) {
        this.accounts = accounts;
    }
    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public void cartaoteste()
    {
        if(cardAmount==1)
        accounts=new DebitAccout();
        Account[] accounts1= new Account[cardAmount];
        //accounts1[1]=

    }



}
