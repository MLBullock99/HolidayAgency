package holidayagency.flights;

import holidayagency.flights.models.FlightDetailsModel;

import java.util.List;

class TestFlightRepository implements FlightsRepository {
    @Override
    public List<FlightDetailsModel> getAllFlights() {
        return List.of(
                // one route from A->B
                new FlightDetailsModel('A', 'B', 100),
                // two routes from C->D. C->E->D will be cheaper
                new FlightDetailsModel('C', 'D' , 500),
                new FlightDetailsModel('C', 'E', 100),
                new FlightDetailsModel('E', 'D', 200)
        );
    }
}
