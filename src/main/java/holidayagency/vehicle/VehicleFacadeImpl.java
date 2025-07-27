package holidayagency.vehicle;

class VehicleFacadeImpl implements VehicleFacade {
    private final GetVehiclePort getVehiclePort;

    VehicleFacadeImpl(GetVehiclePort getVehiclePort) {
        this.getVehiclePort = getVehiclePort;
    }

}
