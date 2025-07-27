package holidayagency.flights.unit;

import holidayagency.flights.FlightsFacade;
import holidayagency.flights.FlightsTestConfig;
import holidayagency.flights.models.CheapestRouteModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class GetCheapestFlightTest {

    FlightsFacade flightsFacade = FlightsTestConfig.flightsTestFacade();

    @Test
    void oneValidFlightRoute_getCheapestFlight_returnsCheapestFlight() {
        CheapestRouteModel cheapestFlight = flightsFacade.getCheapestFlight('A', 'B');

        assertEquals(new CheapestRouteModel(1000, "AB100"), cheapestFlight);
    }

    @Test
    void multipleValidFlightRoutes_getCheapestFlight_returnsCheapestFlight() {
        CheapestRouteModel cheapestFlight = flightsFacade.getCheapestFlight('C', 'D');

        assertEquals(new CheapestRouteModel(3000, "CE100--ED200"), cheapestFlight);
    }

    @Test
    void noValidRoute_getCheapestFlight_returnsNull() {
        CheapestRouteModel cheapestFlight = flightsFacade.getCheapestFlight('A', 'E');

        assertNull(cheapestFlight);
    }
}
