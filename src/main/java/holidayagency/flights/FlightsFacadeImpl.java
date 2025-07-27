package holidayagency.flights;

import holidayagency.flights.models.CheapestFlightModel;

class FlightsFacadeImpl implements FlightsFacade {

    public FlightsFacadeImpl(GetFlightsPort getFlightsPort) {
        this.getFlightsPort = getFlightsPort;
    }

    private final GetFlightsPort getFlightsPort;

    @Override
    public CheapestFlightModel getCheapestFlight(char departureAirport, char destinationAirport) {
        return new GetCheapestFlightUseCase(getFlightsPort).getCheapestFlight(departureAirport, destinationAirport);
    }
}
