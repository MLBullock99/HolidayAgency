package holidayagency.flights;

import holidayagency.flights.models.CheapestRouteModel;

public interface FlightsFacade {

    CheapestRouteModel getCheapestFlight(char departureAirport, char destinationAirport);

}
