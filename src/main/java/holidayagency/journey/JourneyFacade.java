package holidayagency.journey;

import holidayagency.journey.models.CheapestJourneyModel;

public interface JourneyFacade {

    CheapestJourneyModel getCheapestJourney(String journeyString);

}
