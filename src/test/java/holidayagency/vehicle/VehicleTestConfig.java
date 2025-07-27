package holidayagency.vehicle;

public class VehicleTestConfig {

    public VehicleFacade vehiclesTestFacade(){
        return VehicleConfig.vehicleFacade(new TestVehicleRepository());
    }
}
