package dev.berke.app.station;

import dev.berke.app.slot.SlotResponse;

import java.util.List;

public record StationResponse(
        Integer id,
        String name,
        StationStatus status,
        List<SlotResponse> slots
) {
}