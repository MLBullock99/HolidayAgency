package holidayagency.flights;

public final class FlightsConfig {

    public static FlightsFacade flightsFacade(FlightsRepository flightsRepository) {
        return new FlightsFacadeImpl(new GetFlightsAdapter(flightsRepository));
    }
}
