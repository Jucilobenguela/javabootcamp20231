import java.util.Random;

public class TheDrunkBear extends Bear{
    public TheDrunkBear(int battery)
    {
        super(battery);
    }

    @Override
    public void Speakings()
    {
        Random random = new Random();
        int va = random.nextInt(0, getBattery()+1);
        if(va < 2)
        {
            System.out.println("zzzzzzz");
            setBattery(0);
        } else {   setSpeak("I love you");
            chargeBatteryLevel(-1);;}
    }
}
