package holidayagency.flights;

import holidayagency.flights.models.CheapestRouteModel;
import holidayagency.flights.models.FlightDetailsModel;

import java.util.*;
import java.util.stream.Collectors;

import static holidayagency.flights.FlightsConstants.FLIGHT_COST_PER_MILE;

class GetCheapestFlightUseCase {
    private final GetFlightsPort getFlightsPort;

    public GetCheapestFlightUseCase(GetFlightsPort getFlightsPort) {
        this.getFlightsPort = getFlightsPort;
    }

    public CheapestRouteModel getCheapestFlight(char departureAirport, char destinationAirport) {
        List<FlightDetailsModel> flightDetails = getFlightsPort.getFlightDetails();

        // map of all airports and flights leaving them
        Map<Character, List<FlightDetailsModel>> flightsFromAirports = flightDetails.stream()
                .sorted(Comparator.comparing(FlightDetailsModel::distance))
                .collect(Collectors.groupingBy(FlightDetailsModel::departureAirport));

        Map<Character, CheapestRouteModel> cheapestFlightToAirports = new HashMap<>();

        char currentAirport = departureAirport;
        cheapestFlightToAirports.put(currentAirport, new CheapestRouteModel(0, ""));

        // list of all unchecked flights with a departure airport that we can get to
        List<FlightDetailsModel> availableFlights = flightsFromAirports.get(currentAirport);

        while(!availableFlights.isEmpty()) {
            // sort the flights based on cost of reaching their destination from the original departure airport, so that the lowest cost route is checked first
            availableFlights.sort(
                    Comparator.comparingInt(a -> (cheapestFlightToAirports.get(a.departureAirport()).costPerPassenger() + a.distance() * FLIGHT_COST_PER_MILE))
            );

            FlightDetailsModel nextFlight = availableFlights.removeFirst();
            currentAirport = nextFlight.departureAirport();
            char nextDestination = nextFlight.destinationAirport();

            // add the new flight to the current route to the departure airport
            CheapestRouteModel routeWithNewFlight = appendFlight(cheapestFlightToAirports.get(currentAirport), nextFlight);

            // if the destination is the goal, then we have found the cheapest route
            if(nextDestination == destinationAirport) {
                return routeWithNewFlight;
            }

            CheapestRouteModel currentRouteToNextDestination = cheapestFlightToAirports.get(nextDestination);

            // if the destination has not been found before or a shorter route has been found, then update the route
            if(currentRouteToNextDestination == null || currentRouteToNextDestination.costPerPassenger() > routeWithNewFlight.costPerPassenger()) {
                cheapestFlightToAirports.put(nextDestination, routeWithNewFlight);
            }

            // if a new destination has been found, add the outbound flights from that airport to the possible flights
            if(currentRouteToNextDestination == null) {
                List<FlightDetailsModel> flightsFromNextAirport = flightsFromAirports.get(nextDestination);

                if(flightsFromNextAirport != null) {
                    availableFlights.addAll(flightsFromNextAirport);
                }

            }
        }

        // if no route is found, return null
        return null;
    }

    private CheapestRouteModel appendFlight(CheapestRouteModel currentJourney, FlightDetailsModel newFlight) {
        // String.valueOf to make '+' append Strings rather than add character values
        String newFlightRoute = String.valueOf(newFlight.departureAirport()) +
                newFlight.destinationAirport() +
                newFlight.distance();

        String newRoute = Objects.equals(currentJourney.route(), "")
                ? newFlightRoute
                : String.join("--", currentJourney.route(), newFlightRoute);

        return new CheapestRouteModel(
                currentJourney.costPerPassenger() + newFlight.distance() * FLIGHT_COST_PER_MILE,
                newRoute
        );
    }
}
