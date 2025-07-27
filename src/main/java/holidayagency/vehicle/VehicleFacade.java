package holidayagency.vehicle;

import holidayagency.vehicle.models.CheapestVehicleModel;

public interface VehicleFacade {

    CheapestVehicleModel getCheapestVehicle(int distance);

}
