package holidayagency.vehicle;

public final class VehicleConfig {

    public static VehicleFacade vehicleFacade() {
        return new VehicleFacadeImpl();
    }
}
