package holidayagency.flights;

import holidayagency.flights.models.CheapestRouteModel;

class FlightsFacadeImpl implements FlightsFacade {

    public FlightsFacadeImpl(GetFlightsPort getFlightsPort) {
        this.getFlightsPort = getFlightsPort;
    }

    private final GetFlightsPort getFlightsPort;

    @Override
    public CheapestRouteModel getCheapestFlight(char departureAirport, char destinationAirport) {
        return new GetCheapestFlightUseCase(getFlightsPort).getCheapestFlight(departureAirport, destinationAirport);
    }
}
