package holidayagency.journey.models;

public record CheapestJourneyModel(
        String vehicle,
        int vehicleCost,
        String outboundRoute,
        int outboundCost,
        String inboundRoute,
        int inboundCost,
        int totalCost
) {
}
