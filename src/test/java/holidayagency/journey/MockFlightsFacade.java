package holidayagency.journey;

import holidayagency.flights.FlightsFacade;
import holidayagency.flights.models.CheapestRouteModel;

class MockFlightsFacade implements FlightsFacade {

    @Override
    public CheapestRouteModel getCheapestFlight(char departureAirport, char destinationAirport) {
        if(departureAirport == 'C' || departureAirport == 'E') {
            return null;
        }
        return new CheapestRouteModel(5000, String.valueOf(departureAirport) + destinationAirport + "500");
    }
}
