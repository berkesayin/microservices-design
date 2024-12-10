package dev.berke.app.station;

import jakarta.validation.constraints.NotNull;

public record StationRequest(
        Integer id,

        @NotNull(message = "Station name is required")
        String name,

        @NotNull(message = "Station status is required")
        StationStatus status
) {
}
