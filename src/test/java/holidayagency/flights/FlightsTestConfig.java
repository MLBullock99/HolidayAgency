package holidayagency.flights;

public class FlightsTestConfig {

    public FlightsFacade flightsTestFacade(){
        return FlightsConfig.flightsFacade(new TestFlightRepository());
    }
}
