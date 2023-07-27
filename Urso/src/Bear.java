public abstract class  Bear {
    private String speak;
    private int  battery;

    public Bear(int battery)
    {
       this.battery=battery;
    }

    public void setSpeak(String talk)
    {      this.speak=talk;
         System.out.println(this.speak);
    }



    public int getBattery()
    {
        return battery;
    }

    public void setBattery(int percentage)
    {
        this.battery = percentage;

    }
    public void chargeBatteryLevel(int battery)
    {
        this.battery+=battery;
    }

    public abstract void Speakings();

}
