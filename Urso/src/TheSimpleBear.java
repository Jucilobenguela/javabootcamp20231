
public class TheSimpleBear extends Bear {


    public TheSimpleBear(int battery) {
        super(battery);
    }

    @Override
    public void Speakings()
    {
        chargeBatteryLevel(-10);
        setSpeak("I love you");
        if(getBattery()==0) {
            System.out.println("Dead battery");}
    }

}
