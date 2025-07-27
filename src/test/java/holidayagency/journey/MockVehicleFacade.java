package holidayagency.journey;

import holidayagency.vehicle.VehicleFacade;
import holidayagency.vehicle.models.CheapestVehicleModel;

class MockVehicleFacade implements VehicleFacade {

    @Override
    public CheapestVehicleModel getCheapestVehicle(int distance) {
        return new CheapestVehicleModel("Taxi", 1000);
    }
}
