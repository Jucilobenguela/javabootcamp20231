import java.util.Random;

public class TheShop {
    private int createdBears;

    public Bear createBear() {
        Random random = new Random();
        int n = random.nextInt(0, 10);
        createdBears++;
        Bear bear;
        if(n % 5 == 0) {
            bear = new TheCrankyBear(100);
        } else if(n % 2 == 0) {
            bear = new TheSimpleBear(100);
        } else {
            bear = new TheDrunkBear(100);
        }
        return bear;
    }

    public int getCreatedBears() {
        return createdBears;
    }

    public String compare(TheShop theShop) {
        if(theShop.getCreatedBears() > createdBears) {
            return theShop + " is the winner!";
        } else if(theShop.getCreatedBears()  == createdBears) {
            return "No one wins!";
        } else {
            return theShop + " is the winner!";
 }

    }
}
