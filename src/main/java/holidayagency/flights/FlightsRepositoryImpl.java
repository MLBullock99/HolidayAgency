package holidayagency.flights;

public class FlightsRepositoryImpl implements FlightsRepository{
    @Override
    public String[] getAllFlights() {
        return new String[] {
            "AB800", "BC900", "CD400", "DE400",
            "BF400", "CE300", "DE300", "EB600",
            "CE200", "DC700", "EB500", "FD200"
        };
    }
}
