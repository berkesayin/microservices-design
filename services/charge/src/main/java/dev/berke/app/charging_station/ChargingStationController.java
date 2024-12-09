package dev.berke.app.charging_station;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ChargingStationController {

    private final ChargingStationService chargingStationService;

    @GetMapping("/fetch-charging-stations")
    public String fetchChargingStations(
            @RequestParam String location,
            @RequestParam(defaultValue = "20") int limit
    ) {
        return chargingStationService.fetchChargingStations(location, limit);
    }

}