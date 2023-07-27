import java.util.Scanner;

public class RequestCard {
    private Scanner scanner;
    private BankList[] bankLists;
    private CardList[] cardLists;

    private int n;
    public RequestCard() {
        this.bankLists = BankList.values();
        this.cardLists = CardList.values();
        scanner = new Scanner(System.in);


    }
    public void requestCard() {
        System.out.println("\n(Please enter a number to make the choice!)\n");
        System.out.println("Which bank do you want to open the account with?");
        chooseBank();
        System.out.println("\nWhich card do you want\n");
        chooseCard();
        System.out.println("");

    }

    public void chooseBank() {
        for (BankList b : bankLists) {
            System.out.println(b.getIdBank() + ". " + b.getNameBank());
        }
        n = scanner.nextInt();
        boolean verdade = true;
        while (verdade) {
            if (n > 0 && n < 6) {
                if (n == bankLists[n - 1].getIdBank()) {
                    System.out.println(bankLists[n-1].name());
                    System.out.println("Welcome to " + bankLists[n - 1].getNameBank());
                    break;
                }
            } else {
                System.out.println("Invalid data! Insert the correct number.\n");
                chooseBank();
                break;
            }

        }
    }

    public void chooseCard() {
        for (CardList c : cardLists) {
            System.out.println(c.getIdCard() + ". " + c.getNameCard());
        }
        n = scanner.nextInt();
        System.out.println("Name: ");



        boolean correct = true;
        while (correct) {
            if (n > 0 && n < 4) {
                if (n == cardLists[n - 1].getIdCard()) {

                    System.out.println(cardLists[n-1].name());
                    System.out.println("Option " + cardLists[n - 1].getNameCard());
                    //if(n==1){ DebitAccout debitAccout=new DebitAccout();
                    // }


                    break;
                }
            }
            else{
                System.out.println("\nInvalid data! Insert the correct number.\n");
                chooseCard();
                break;
            }

        }

    }

}
