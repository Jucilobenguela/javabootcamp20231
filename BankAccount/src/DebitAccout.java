public class DebitAccout extends Account{
    public DebitAccout()
    {
        super();

    }
    @Override
    public void addBalance(double balance) {
        setBalance(balance);

    }

    @Override
    public void payment(double payment) {
        super.setBalance(super.getBalance()-payment);

    }

    public void removeBalance( double balance)
   {
       super.setBalance(super.getBalance()-balance);
   }
}
