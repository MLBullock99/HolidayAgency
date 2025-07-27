package holidayagency.journey;

import holidayagency.flights.FlightsFacade;
import holidayagency.flights.models.CheapestFlightModel;
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
        int totalVehicleCost = (journey.numPassengers() / 4 + 1) * cheapestVehicle.costPerVehicle();

        CheapestFlightModel cheapestOutboundFlight = flightsFacade.getCheapestFlight(journey.departureAirport(), journey.destinationAirport());
        if(cheapestOutboundFlight == null) {
            cheapestOutboundFlight = new CheapestFlightModel(0, "No outbound flight");
        }
        int totalOutboundFlightCost = cheapestOutboundFlight.costPerPassenger() * journey.numPassengers();

        CheapestFlightModel cheapestInboundFlight = flightsFacade.getCheapestFlight(journey.destinationAirport(), journey.departureAirport());
        if(cheapestInboundFlight == null) {
            cheapestInboundFlight = new CheapestFlightModel(0, "No inbound flight");
        }
        int totalInboundFlightCost = cheapestInboundFlight.costPerPassenger() * journey.numPassengers();

        int totalCost = totalOutboundFlightCost == 0 || totalInboundFlightCost == 0
            ? 0
            : totalVehicleCost + totalOutboundFlightCost + totalInboundFlightCost;

        return new CheapestJourneyModel(
                cheapestVehicle.vehicle(), totalVehicleCost,
                cheapestOutboundFlight.route(), totalOutboundFlightCost,
                cheapestInboundFlight.route(), totalInboundFlightCost,
                totalCost
        );
    }

    private JourneyModel parseJourney(String journey) {
        String[] journeyDetails = journey.split(",");

        int numPassengers = Integer.parseInt(journeyDetails[0].trim());
        char departureAirport = journeyDetails[1].trim().charAt(0);
        int distanceToAirport = Integer.parseInt(journeyDetails[1].trim().substring(1));
        char destinationAirport = journeyDetails[2].trim().charAt(0);

        return new JourneyModel(numPassengers, departureAirport, distanceToAirport, destinationAirport);
    }
}
