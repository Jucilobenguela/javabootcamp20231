import java.util.Scanner;

public  abstract class Vehicle {
    private EnumVehicles modelName;
    private Scanner scanner;
    private double distancePerKm;
    private double fuelLiter;
    private double vehicleDistance;
    private double time;
    private double gasConsumptionValue;
    private int maximumSpeedValue;
    private static int amountVehicle;

    public Vehicle(EnumVehicles modelName, double vehicleDistance, double time, int maximumSpeedValue) {
        amountVehicle++;
        this.scanner = new Scanner(System.in);
        this.modelName = modelName;
        this.fuelLiter = 25;
        this.vehicleDistance = vehicleDistance;
        this.time=time;
        this.maximumSpeedValue = maximumSpeedValue;
    }

    public static int getAmountVehicle() {
        return amountVehicle;
    }

    public EnumVehicles getModelName() {
        return modelName;
    }
    public double getFuelLiter() {
        return fuelLiter;
    }
    public void setFuelLiter()
    {
        this.fuelLiter = this.fuelLiter-(this.vehicleDistance/10);
    }


    public double getDistancePerKm() {
        return distancePerKm;
    }

    public double getVehicleDistance() {
        return vehicleDistance;
    }

    public void setVehicleDistance(int vehicleDisplacement) {
        this.vehicleDistance = vehicleDisplacement;
    }

    public double getGasConsumptionValue() {
        return gasConsumptionValue;
    }

    public void setGasConsumptionValue(double gasConsumptionValue) {
        this.gasConsumptionValue = gasConsumptionValue;
    }

    public int getMaximumSpeedValue() {
        return maximumSpeedValue;
    }
    public boolean FuelLiter()
    {
        System.out.println("Qual a distancia necessaria?");
        this.vehicleDistance=scanner.nextDouble();

        if( this.fuelLiter < this.vehicleDistance/10)
        {
            System.out.println("Insufficient Fuel");
            System.out.println("Refuel? Y/N");
            char yOrN = scanner.next().charAt(0);
            if (yOrN=='Y' || yOrN =='y')
            {
                System.out.print("Amount of fuel: ");
                double amount = scanner.nextDouble();
                this.fuelLiter=amount*1.70;
                return FuelLiter();
            }else if (yOrN =='n'|| yOrN=='N'){System.out.println("Engine off"); }
            else
            {
                System.out.println("Invalid data");
                FuelLiter();
            }
        }else
             {

             }
        System.out.println("Available Fuel " +this.fuelLiter);
        return true ;
    }


    public boolean returnVehicle() {

       if (this.fuelLiter<20)
       {
           double value = 25-this.fuelLiter;
           System.out.println("You will have to pay: "+value*2.5+"Eur");
           return false;
       }else {System.out.println("Successfully returned vehicle!");}
       return true;
    }
    public boolean driveVehicle(double vehicleDistance, double time)
    {


        if(vehicleDistance/time > maximumSpeedValue )
        {
            System.out.println("Speeding!");
            return false;
        }
        return true;
    }
}
