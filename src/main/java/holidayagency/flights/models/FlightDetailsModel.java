package holidayagency.flights.models;

public record FlightDetailsModel(
        char departureAirport,
        char destinationAirport,
        int distance
) {
}
