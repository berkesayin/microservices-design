package dev.berke.app.slot;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record SlotRequest(
        Integer id,

        @NotNull(message = "Slot number is required")
        Integer slotNumber,

        @NotNull(message = "Fast charger flag is required")
        Boolean isFastCharger,

        @NotNull(message = "Slot status is required")
        String status,

        @Positive(message = "Available hour should be positive")
        double availableHour,

        @Positive(message = "Price per hour should be positive")
        BigDecimal pricePerHour,

        @NotNull(message = "Slot's station ID is required")
        Integer stationId
) {
}
