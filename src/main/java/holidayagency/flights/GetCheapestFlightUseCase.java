package holidayagency.flights;

import holidayagency.flights.models.CheapestFlightModel;
import holidayagency.flights.models.FlightDetailsModel;

import java.util.*;
import java.util.stream.Collectors;

class GetCheapestFlightUseCase {
    private final GetFlightsPort getFlightsPort;

    public GetCheapestFlightUseCase(GetFlightsPort getFlightsPort) {
        this.getFlightsPort = getFlightsPort;
    }

    public CheapestFlightModel getCheapestFlight(char departureAirport, char destinationAirport) {
        List<FlightDetailsModel> flightDetails = getFlightsPort.getFlightDetails();

        Map<Character, List<FlightDetailsModel>> flightsFromAirports = flightDetails.stream()
                .sorted(Comparator.comparing(FlightDetailsModel::distance))
                .collect(Collectors.groupingBy(FlightDetailsModel::departureAirport));

        Map<Character, CheapestFlightModel> cheapestFlightToAirports = new HashMap<>();

        char currentAirport = departureAirport;

        cheapestFlightToAirports.put(currentAirport, new CheapestFlightModel(0, ""));

        List<FlightDetailsModel> availableFlights = flightsFromAirports.get(currentAirport);

        while(!availableFlights.isEmpty()) {
            availableFlights.sort(
                    Comparator.comparingInt(a -> (cheapestFlightToAirports.get(a.departureAirport()).costPerPassenger() + a.distance() * 10))
            );

            FlightDetailsModel nextFlight = availableFlights.getFirst();
            availableFlights.removeFirst();
            currentAirport = nextFlight.departureAirport();

            char nextDestination = nextFlight.destinationAirport();
            CheapestFlightModel routeWithNewFlight = appendFlight(cheapestFlightToAirports.get(currentAirport), nextFlight);

            if(nextDestination == destinationAirport) {
                return routeWithNewFlight;
            }

            CheapestFlightModel currentRouteToNextDestination = cheapestFlightToAirports.get(nextDestination);

            if(currentRouteToNextDestination == null || currentRouteToNextDestination.costPerPassenger() > routeWithNewFlight.costPerPassenger()) {
                cheapestFlightToAirports.put(nextDestination, routeWithNewFlight);
            }

            if(currentRouteToNextDestination == null) {
                List<FlightDetailsModel> flightsFromNextAirport = flightsFromAirports.get(nextDestination);

                if(flightsFromNextAirport != null) {
                    availableFlights.addAll(flightsFromNextAirport);
                }

            }
        }

        return null;
    }

    private CheapestFlightModel appendFlight(CheapestFlightModel currentJourney, FlightDetailsModel newFlight) {
        String newFlightRoute = String.valueOf(newFlight.departureAirport()) +
                newFlight.destinationAirport() +
                newFlight.distance();

        String newRoute = Objects.equals(currentJourney.route(), "")
                ? newFlightRoute
                : String.join("--", currentJourney.route(), newFlightRoute);

        return new CheapestFlightModel(
                currentJourney.costPerPassenger() + newFlight.distance() * 10,
                newRoute
        );
    }
}
