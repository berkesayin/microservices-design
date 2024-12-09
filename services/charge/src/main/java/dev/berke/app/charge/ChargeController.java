package dev.berke.app.charge;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChargeController {

    private final ChargeService evChargeService;

    @GetMapping("/fetch-charging-stations")
    public String fetchChargingStations(
            @RequestParam String location,
            @RequestParam(defaultValue = "20") int limit
    ) {
        return evChargeService.fetchChargingStations(location, limit);
    }
}
