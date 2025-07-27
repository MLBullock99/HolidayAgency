package holidayagency.vehicle.unit;

import holidayagency.vehicle.VehicleFacade;
import holidayagency.vehicle.VehicleTestConfig;
import holidayagency.vehicle.models.CheapestVehicleModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetCheapestVehicleTest {

    VehicleFacade vehicleFacade = VehicleTestConfig.vehiclesTestFacade();

    @Test
    public void distanceWhereTaxiIsCheaper_getCheapestVehicle_returnsTaxiAndCost() {
        assertEquals(new CheapestVehicleModel("Taxi", 400), vehicleFacade.getCheapestVehicle(5));
    }

    @Test
    public void distanceWhereCarIsCheaper_getCheapestVehicle_returnsCarAndCost() {
        assertEquals(new CheapestVehicleModel("Car", 1100), vehicleFacade.getCheapestVehicle(20));
    }

}
