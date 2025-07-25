package holidayagency.flights;

public class FlightsTestConfig {

    public FlightsFacade flightsFacade(){
        return new FlightsFacadeImpl(new TestFlightRepository());
    }
}
