package holidayagency.journey;

import holidayagency.flights.FlightsFacade;
import holidayagency.flights.models.CheapestFlightModel;

class MockFlightsFacade implements FlightsFacade {

    @Override
    public CheapestFlightModel getCheapestFlight(char departureAirport, char destinationAirport) {
        return new CheapestFlightModel(500, departureAirport + destinationAirport + "500");
    }
}
