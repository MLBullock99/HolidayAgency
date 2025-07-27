package holidayagency.journey;

import holidayagency.flights.FlightsFacade;
import holidayagency.flights.models.CheapestFlightModel;

class MockFlightsFacade implements FlightsFacade {

    @Override
    public CheapestFlightModel getCheapestFlight(char departureAirport, char destinationAirport) {
        if(departureAirport == 'C' || departureAirport == 'E') {
            return null;
        }
        return new CheapestFlightModel(5000, String.valueOf(departureAirport) + destinationAirport + "500");
    }
}
