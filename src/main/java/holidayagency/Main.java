package holidayagency;

import holidayagency.flights.FlightsConfig;
import holidayagency.flights.FlightsFacade;
import holidayagency.flights.FlightsRepository;
import holidayagency.flights.FlightsRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        FlightsRepository flightsRepository = new FlightsRepositoryImpl();

        FlightsFacade flightsFacade = FlightsConfig.flightsFacade(flightsRepository);
    }
}