import java.util.Scanner;

public class Client {
    Scanner scanner = new Scanner(System.in);
    Vehicle vehicle;
   private double distancePerHour;
   int idVehicleRentalShop;
    double timePerHour;

    public Client( int idVehicleRentalShop) {
        this.idVehicleRentalShop=idVehicleRentalShop;
        drive();
        rentedVehicleCar();
        vehicle.FuelLiter();
        vehicle.returnVehicle();


    }

    public int getIdVehicleRentalShop() {
        return idVehicleRentalShop;
    }
    private void iniciar(){

        System.out.println("Speed Km/h");
        this.distancePerHour = scanner.nextDouble();
        System.out.println("Qual o tempo Necessaria?");
        this.timePerHour= scanner.nextDouble();
        rentedVehicleCar();
        vehicle.driveVehicle(this.distancePerHour, this.timePerHour);


    }
  private void drive()
    {
        System.out.println("Star trip Y/N?");
        char letter  = scanner.next().charAt(0);
        if(letter=='y'|| letter=='Y')
        {
            iniciar();



        } else if (letter =='n'||letter =='N') {
            System.out.println("Carro desligado!");
        }else
            {
                System.out.println("Dados incorrecto");
                drive();
            }

    }

    public void rentedVehicleCar(){

        switch (idVehicleRentalShop)
        {
            case 1:
                car(EnumVehicles.VW, distancePerHour, timePerHour);
                break;
            case 2:
                car(EnumVehicles.MERCEDES, distancePerHour, timePerHour);
                break;
            case 3:
                car(EnumVehicles.CITROEN, distancePerHour, timePerHour);
                break;
            case 4:
                motorcycle(EnumVehicles.HONDA, distancePerHour,timePerHour);
                break;
            case 5:
                motorcycle(EnumVehicles.VOGE, distancePerHour,timePerHour);
                break;
            case 6:
                motorcycle(EnumVehicles.MOTOGUZZI, distancePerHour,timePerHour);
                break;
            default:
                System.out.println("Please, choose correct option!\n");
        }


    }
    private void car(EnumVehicles enumVehicles, double vehicleDistance,  double time){
        vehicle=new CarVehicle(enumVehicles, vehicleDistance, time);

    }
    private void motorcycle(EnumVehicles enumVehicles, double vehicleDistance,  double time){
        vehicle=new MotorcycleVehicle(enumVehicles, vehicleDistance, time);

    }
}
