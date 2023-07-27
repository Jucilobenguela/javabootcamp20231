import java.util.Scanner;

public class Bank {

    private DebitAccout debitAccout;
    private CreditAccout creditAccout;
    private Client[] clients;
   private CardList cardList;


    public Bank(CardList cardList, Client[] clients) {
        this.cardList=cardList;
        this.clients=clients;
    }

    public Account account() {
        for (int i = 1; i < clients.length; i++) {
            if (clients[i].getCardAmount() == 1) {
                return new DebitAccout();

            }

        }
        return null;
    }


}



