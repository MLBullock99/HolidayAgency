package holidayagency.vehicle;

class GetVehicleAdapter implements GetVehiclePort {
    private final VehicleRepository vehicleRepository;

    GetVehicleAdapter(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }


}
