package holidayagency.journey.unit;

import holidayagency.journey.JourneyFacade;
import holidayagency.journey.JourneyTestConfig;
import holidayagency.journey.models.CheapestJourneyModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetCheapestJourneyTest {

    JourneyFacade journeyFacade = JourneyTestConfig.journeyTestFacade();

    @Test
    public void journeyWith1Passenger_getCheapestJourney_returnsJourneyDetails() {
        CheapestJourneyModel expectedOutput = new CheapestJourneyModel(
                "Taxi", 1000,
                "AB500", 5000,
                "BA500", 5000,
                11000
        );
        assertEquals(expectedOutput, journeyFacade.getCheapestJourney("1, A10, B"));
    }

    @Test
    public void journeyWith5Passengers_getCheapestJourney_returnsJourneyDetails() {
        CheapestJourneyModel expectedOutput = new CheapestJourneyModel(
                "Taxi", 2000,
                "AB500", 25000,
                "BA500", 25000,
                52000
        );
        assertEquals(expectedOutput, journeyFacade.getCheapestJourney("5, A10, B"));
    }
    @Test
    public void journeyWithNoOutbound_getCheapestJourney_returnsJourneyDetailsWithNoOutbound() {
        CheapestJourneyModel expectedOutput = new CheapestJourneyModel(
                "Taxi", 1000,
                "No outbound flight", 0,
                "DC500", 5000,
                0
        );
        assertEquals(expectedOutput, journeyFacade.getCheapestJourney("1, C10, D"));
    }
    @Test
    public void journeyWithNoInbound_getCheapestJourney_returnsJourneyDetailsWithNoInbound() {
        CheapestJourneyModel expectedOutput = new CheapestJourneyModel(
                "Taxi", 1000,
                "DC500", 5000,
                "No inbound flight", 0,
                0
        );
        assertEquals(expectedOutput, journeyFacade.getCheapestJourney("1, D10, C"));
    }
    @Test
    public void journeyWithNoOutboundOrInbound_getCheapestJourney_returnsJourneyDetailsWithNoOutboundOrInbound() {
        CheapestJourneyModel expectedOutput = new CheapestJourneyModel(
                "Taxi", 1000,
                "No outbound flight", 0,
                "No inbound flight", 0,
                0
        );
        assertEquals(expectedOutput, journeyFacade.getCheapestJourney("1, C10, E"));
    }
}
