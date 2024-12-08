package dev.berke.app.slot;

import java.math.BigDecimal;

public record SlotResponse(
        Integer id,
        Integer slotNumber,
        Boolean isFastCharger,
        String status,
        double availableHour,
        BigDecimal pricePerHour,
        Integer stationId,
        String stationName,
        String stationStatus
) {
}