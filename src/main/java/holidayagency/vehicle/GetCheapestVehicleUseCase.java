package holidayagency.vehicle;


import holidayagency.vehicle.models.CheapestVehicleModel;

import static holidayagency.vehicle.VehicleConstants.*;

class GetCheapestVehicleUseCase {

    public CheapestVehicleModel getCheapestVehicle(int distance) {
        int taxiCost = distance * TAXI_COST_PER_MILE;
        int carCost = distance * CAR_COST_PER_MILE + CAR_PARKING_COST;

        return taxiCost < carCost
                ? new CheapestVehicleModel("Taxi", taxiCost)
                : new CheapestVehicleModel("Car", carCost);
    }
}
