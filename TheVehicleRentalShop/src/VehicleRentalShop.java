
import java.util.Scanner;

public class VehicleRentalShop {
    EnumVehicles[] enumVehicles = EnumVehicles.values();
    Scanner scanner = new Scanner(System.in);
    private char letter;
    private int idCliente;
    public VehicleRentalShop(){
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void vehiclesForLease() {
        System.out.println("Do you want to rent some vehicles? Y/N");
        letter = scanner.next().charAt(0);
        if(letter == 'y' || letter== 'Y'){
            chooseVehicle();

        } else if (letter == 'n' || letter=='N') {
            System.out.println("Tank you, see you next time.");

        }else {
            System.out.println("Please, choose correct option!\n");
           vehiclesForLease();
        }
    }
    private void chooseVehicle() {

        for (EnumVehicles enumVehicles1 : enumVehicles) {
            System.out.println(enumVehicles1.getValue() + ": " + enumVehicles1.name());
        }
        System.out.println("Choose the Vehicle:");
        this.idCliente = scanner.nextInt();
        vehicle();
    }
    public int vehicle()
    {
        switch (this.getIdCliente()) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            default:
                System.out.println("Please, choose correct option1!\n");
                chooseVehicle();
        }
        return this.idCliente;

    }

}
