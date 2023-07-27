
public class Main {
    public static void main(String[] args) {


       VehicleRentalShop vehicleRentalShop=new VehicleRentalShop();
      vehicleRentalShop.vehiclesForLease();
        Client client= new Client(vehicleRentalShop.getIdCliente());
        //System.out.println(client.getIdVehicleRentalShop());


    }
}