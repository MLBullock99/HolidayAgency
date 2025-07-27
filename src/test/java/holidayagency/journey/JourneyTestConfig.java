package holidayagency.journey;

public final class JourneyTestConfig {

    public static JourneyFacade journeyTestFacade() {
        return JourneyConfig.journeyFacade(new MockVehicleFacade(), new MockFlightsFacade());
    }
}
