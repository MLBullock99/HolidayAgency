package holidayagency.journey;

import holidayagency.flights.FlightsFacade;
import holidayagency.flights.models.CheapestRouteModel;
import holidayagency.journey.models.CheapestJourneyModel;
import holidayagency.journey.models.JourneyModel;
import holidayagency.vehicle.VehicleFacade;
import holidayagency.vehicle.models.CheapestVehicleModel;

class GetCheapestJourneyUseCase {

    private final VehicleFacade vehicleFacade;
    private final FlightsFacade flightsFacade;

    public GetCheapestJourneyUseCase(VehicleFacade vehicleFacade, FlightsFacade flightsFacade) {
        this.vehicleFacade = vehicleFacade;
        this.flightsFacade = flightsFacade;
    }

    public CheapestJourneyModel getCheapestJourney(String journeyString) {
        JourneyModel journey = parseJourney(journeyString);

        CheapestVehicleModel cheapestVehicle = vehicleFacade.getCheapestVehicle(journey.distanceToAirport());
        // four people per vehicle, multiplied by the cost of one vehicle
        int totalVehicleCost = (journey.numPassengers() / 4 + 1) * cheapestVehicle.costPerVehicle();

        CheapestRouteModel cheapestOutboundRoute = flightsFacade.getCheapestFlight(journey.departureAirport(), journey.destinationAirport());
        // if the route is null then no outbound flight is found
        if(cheapestOutboundRoute == null) {
            cheapestOutboundRoute = new CheapestRouteModel(0, "No outbound flight");
        }
        int totalOutboundRouteCost = cheapestOutboundRoute.costPerPassenger() * journey.numPassengers();

        CheapestRouteModel cheapestInboundRoute = flightsFacade.getCheapestFlight(journey.destinationAirport(), journey.departureAirport());
        if(cheapestInboundRoute == null) {
            cheapestInboundRoute = new CheapestRouteModel(0, "No inbound flight");
        }
        int totalInboundRouteCost = cheapestInboundRoute.costPerPassenger() * journey.numPassengers();

        int totalCost = totalOutboundRouteCost == 0 || totalInboundRouteCost == 0
            ? 0
            : totalVehicleCost + totalOutboundRouteCost + totalInboundRouteCost;

        return new CheapestJourneyModel(
                cheapestVehicle.vehicle(), totalVehicleCost,
                cheapestOutboundRoute.route(), totalOutboundRouteCost,
                cheapestInboundRoute.route(), totalInboundRouteCost,
                totalCost
        );
    }

    private JourneyModel parseJourney(String journey) {
        String[] journeyDetails = journey.split(",");

        // getting the values from journeyDetails, trimming the whitespace from the content
        int numPassengers = Integer.parseInt(journeyDetails[0].trim());
        char departureAirport = journeyDetails[1].trim().charAt(0);
        int distanceToAirport = Integer.parseInt(journeyDetails[1].trim().substring(1));
        char destinationAirport = journeyDetails[2].trim().charAt(0);

        return new JourneyModel(numPassengers, departureAirport, distanceToAirport, destinationAirport);
    }
}
