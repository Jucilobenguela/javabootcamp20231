import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        TheShop theShop = new TheShop();
        Bear[] bears = new Bear[5];


        for(int i = 0; i < bears.length; i++) {
            bears[i] = theShop.createBear();
        }
        System.out.println(Arrays.toString(bears));

        for(Bear bear : bears) {
            while(true) {

                if(bear instanceof TheSimpleBear) {
                    ((TheSimpleBear) bear).Speakings();
                }
                if(bear instanceof TheCrankyBear) {
                    ((TheCrankyBear) bear).Speakings();
                }
                if(bear instanceof TheDrunkBear) {
                    ((TheDrunkBear) bear).Speakings();
                }
            }
        }

        TheShop shop2 = new TheShop();
        TheShop shop3 = new TheShop();


        System.out.println(theShop.compare(shop2));
        System.out.println(shop2.compare(shop3));

    }
}