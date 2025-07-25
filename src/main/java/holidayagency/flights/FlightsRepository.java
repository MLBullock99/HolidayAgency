package holidayagency.flights;

import holidayagency.flights.models.FlightDetailsModel;

import java.util.List;

interface FlightsRepository {

    List<FlightDetailsModel> getAllFlights();
}
