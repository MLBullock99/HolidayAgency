package holidayagency.flights;

import holidayagency.flights.models.CheapestFlightModel;

public interface FlightsFacade {

    CheapestFlightModel getCheapestFlight(char departureAirport, char destinationAirport);

}
