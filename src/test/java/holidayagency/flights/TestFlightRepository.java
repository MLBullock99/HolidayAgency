package holidayagency.flights;

class TestFlightRepository implements FlightsRepository {
    @Override
    public String[] getAllFlights() {
        return new String[]{
                // one route from A->B
                "AB100",
                // two routes from C->D. C->E->D will be cheaper
                "CD500", "CE100", "ED200"
        };
    }
}
