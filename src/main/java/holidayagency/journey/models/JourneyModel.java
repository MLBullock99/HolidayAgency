package holidayagency.journey.models;

public record JourneyModel(
        int numPassengers,
        char departureAirport,
        int distanceToAirport,
        char destinationAirport
) {
}
