package holidayagency.flights;

public final class FlightsTestConfig {

    public static FlightsFacade flightsTestFacade(){
        return FlightsConfig.flightsFacade(new TestFlightRepository());
    }
}
