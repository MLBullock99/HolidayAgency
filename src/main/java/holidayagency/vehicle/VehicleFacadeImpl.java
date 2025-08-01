package holidayagency.vehicle;

import holidayagency.vehicle.models.CheapestVehicleModel;

class VehicleFacadeImpl implements VehicleFacade {

    @Override
    public CheapestVehicleModel getCheapestVehicle(int distance) {
        return new GetCheapestVehicleUseCase().getCheapestVehicle(distance);
    }

}
