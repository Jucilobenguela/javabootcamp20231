public class CreditAccout extends Account{
    public CreditAccout(Integer number, String holder) {
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
}
