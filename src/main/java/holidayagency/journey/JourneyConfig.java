package holidayagency.journey;

import holidayagency.flights.FlightsFacade;
import holidayagency.vehicle.VehicleFacade;

public final class JourneyConfig {

    public static JourneyFacade journeyFacade(VehicleFacade vehicleFacade, FlightsFacade flightsFacade) {
        return new JourneyFacadeImpl(vehicleFacade, flightsFacade);
    }
}
