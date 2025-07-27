package holidayagency.vehicle;

public final class VehicleConfig {

    public static VehicleFacade vehicleFacade(VehicleRepository vehiclesRepository) {
        return new VehicleFacadeImpl(new GetVehicleAdapter(vehiclesRepository));
    }
}
