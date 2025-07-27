package holidayagency.journey;

import holidayagency.flights.FlightsFacade;
import holidayagency.journey.models.CheapestJourneyModel;
import holidayagency.vehicle.VehicleFacade;

class JourneyFacadeImpl implements JourneyFacade {

    private final VehicleFacade vehicleFacade;
    private final FlightsFacade flightsFacade;

    public JourneyFacadeImpl(VehicleFacade vehicleFacade, FlightsFacade flightsFacade) {
        this.vehicleFacade = vehicleFacade;
        this.flightsFacade = flightsFacade;
    }

    @Override
    public CheapestJourneyModel getCheapestJourney(String journeyString) {
        return new GetCheapestJourneyUseCase(vehicleFacade, flightsFacade).getCheapestJourney(journeyString);
    }
}
