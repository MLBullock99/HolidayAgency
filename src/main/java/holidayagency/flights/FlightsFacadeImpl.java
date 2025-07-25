package holidayagency.flights;

import holidayagency.flights.models.CheapestFlightModel;

class FlightsFacadeImpl implements FlightsFacade {

    public FlightsFacadeImpl(FlightsRepository flightsRepository) {
        this.flightsRepository = flightsRepository;
    }

    FlightsRepository flightsRepository;

    @Override
    public CheapestFlightModel getCheapestFlight(char departureAirport, char destinationAirport) {
        return null;
    }
}
