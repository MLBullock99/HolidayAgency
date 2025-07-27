package holidayagency;

import holidayagency.flights.FlightsConfig;
import holidayagency.flights.FlightsFacade;
import holidayagency.flights.FlightsRepository;
import holidayagency.flights.FlightsRepositoryImpl;
import holidayagency.journey.JourneyConfig;
import holidayagency.journey.JourneyFacade;
import holidayagency.journey.models.CheapestJourneyModel;
import holidayagency.vehicle.VehicleConfig;
import holidayagency.vehicle.VehicleFacade;

public class Main {
    public static void main(String[] args) {
        // Journeys to check
        String[] journeyInputs = new String[] {
                "2, B20, D",
                "1, B30, D",
                "2, A20, D",
                "2, C30, A",
                "2, B10, C",
                "5, B10, C",
                "1, D25, B",
                "4, D40, A",
                "2, B5, D",
                "9, B30, D"
        };

        VehicleFacade vehicleFacade = VehicleConfig.vehicleFacade();

        FlightsRepository flightsRepository = new FlightsRepositoryImpl();
        FlightsFacade flightsFacade = FlightsConfig.flightsFacade(flightsRepository);

        JourneyFacade journeyFacade = JourneyConfig.journeyFacade(vehicleFacade, flightsFacade);

        for(int i = 0; i < journeyInputs.length; i++){
            System.out.println((i + 1) + parseOutput(journeyFacade.getCheapestJourney(journeyInputs[i])));
        }
    }

    private static String parseOutput(CheapestJourneyModel cheapestJourney) {
        return " | " + cheapestJourney.vehicle() +
                " | " + parseIntToCurrency(cheapestJourney.vehicleCost()) +
                " | " + cheapestJourney.outboundRoute() +
                " | " + parseIntToCurrency(cheapestJourney.outboundCost()) +
                " | " + cheapestJourney.inboundRoute() +
                " | " + parseIntToCurrency(cheapestJourney.inboundCost()) +
                " | " + parseIntToCurrency(cheapestJourney.totalCost());
    }

    private static String parseIntToCurrency(int cost) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(cost));
        // add '0's to the start until the length is at least 3, so that 0 is displayed as 0.00
        while(stringBuilder.length() < 3) {
            stringBuilder.insert(0, "0");
        }

        stringBuilder.insert(stringBuilder.length() - 2, ".");
        return stringBuilder.toString();
    }
}