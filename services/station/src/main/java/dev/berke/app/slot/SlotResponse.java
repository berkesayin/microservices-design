package dev.berke.app.slot;

import dev.berke.app.station.StationStatus;

import java.math.BigDecimal;

public record SlotResponse(
        Integer id,
        Integer slotNumber,
        Boolean isFastCharger,
        SlotStatus status,
        double availableHour,
        BigDecimal pricePerHour,
        Integer stationId,
        String stationName,
        StationStatus stationStatus
) {
}