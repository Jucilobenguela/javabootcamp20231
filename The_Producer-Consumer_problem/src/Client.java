public class Client implements  Runnable{
    private int numberOrder;
    private Restaurant restaurant;
    public Client(Restaurant restaurant){
        this.restaurant=restaurant;
    }
    public Client (int numberOrder){
        this.numberOrder= numberOrder;
    }
    @Override
    public void run() {
        while (!restaurant.close()){
            try {
                Order order = restaurant.removeOrder();
                if(order != null){
                  Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int getNumberOrder() {
        return numberOrder;
    }
}
