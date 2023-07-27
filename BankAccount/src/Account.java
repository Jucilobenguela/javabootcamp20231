public abstract class Account {

    private double balance;

    public Account() {
        this.balance = 0;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public abstract void addBalance(double balance);
    public abstract void payment(double payment);
}
