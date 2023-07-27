import java.util.LinkedList;
import java.util.Queue;

public class Restaurant {
    private int sale = 0;
    private Queue<Order> orders;
    private int orderQuantity;
    private boolean isClose;
    private final static int salesNumberRequired = 5;

    public Restaurant(int orderQuantity) {
        this.orders = new LinkedList<>();
        this.orderQuantity = new Client(orderQuantity).getNumberOrder();
        this.isClose = false;
    }

    public synchronized void addOrder(Order order) throws InterruptedException {
        while (orders.size() >= this.orderQuantity) {
          wait();
        }
        if (!isClose && (orders.size() < this.orderQuantity)) {
            orders.add(order);
            System.out.println("Add: " + order.getId());
            if (orders.size() == this.orderQuantity) {
                this.sale++;
                notify();
            }
        }
    }
    public synchronized Order removeOrder() throws InterruptedException {
        while (orders.isEmpty() && !isClose) {
            wait();
        }
        if (!orders.isEmpty() && orders.size() == this.orderQuantity) {
            Order order = null;
            for (int i = 0; i < this.orderQuantity; i++) {
                order = orders.remove();
                System.out.println("Removed: " + order.getId());
            }
            if (this.sale == salesNumberRequired) {
                this.isClose=true;
            }
            notify();
            return order;
        }
        return null;
    }
    public boolean close() {
        return isClose;

    }
}
