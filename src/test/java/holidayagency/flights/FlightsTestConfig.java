package holidayagency.flights;

public class FlightsTestConfig {

    public FlightsFacade flightsFacade(){
        return FlightsConfig.flightsFacade(new TestFlightRepository());
    }
}
