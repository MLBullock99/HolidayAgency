package holidayagency.flights;

import holidayagency.flights.models.FlightDetailsModel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class GetFlightsAdapter implements GetFlightsPort{
    private final FlightsRepository flightsRepository;

    GetFlightsAdapter(FlightsRepository flightsRepository) {
        this.flightsRepository = flightsRepository;
    }

    public List<FlightDetailsModel> getFlightDetails(){
        return Arrays.stream(flightsRepository.getAllFlights())
                .map(this::parseFlight)
                .collect(Collectors.toList());
    }

    private FlightDetailsModel parseFlight(String flightString) {
        char departureAirport = flightString.charAt(0);
        char destinationAirport = flightString.charAt(1);
        int distance = Integer.parseInt(flightString.substring(2));

        return new FlightDetailsModel(departureAirport, destinationAirport, distance);
    }
}
