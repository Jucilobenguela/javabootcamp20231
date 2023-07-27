public class TheCrankyBear extends Bear{
    public TheCrankyBear(int battery) {
        super(battery);
    }

    @Override
    public void Speakings() {
        int va = 5;
        if (getBattery()<=va && getBattery()>0)
        {
            System.out.println("Sang");
            setBattery(0);
        } else if (getBattery()<=0) {
            System.out.println("no change");
        } else {
            setSpeak("I love you");
            chargeBatteryLevel(-1);
        }
    }

        }

