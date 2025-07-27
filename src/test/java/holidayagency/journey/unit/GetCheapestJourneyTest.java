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
}
