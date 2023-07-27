public class Cook implements Runnable{
    private Restaurant restaurant;
    public Cook(Restaurant restaurant){
        this.restaurant = restaurant;

    }
    @Override
    public void run() {
        int orderId = 1;
        while (!restaurant.close()){
            try {
                Order order = new Order(orderId);
                restaurant.addOrder(order);
                Thread.sleep(100);
                orderId++;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
