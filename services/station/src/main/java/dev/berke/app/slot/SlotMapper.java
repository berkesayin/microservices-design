package dev.berke.app.slot;

import dev.berke.app.station.Station;
import dev.berke.app.station.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SlotMapper {

    private final StationRepository stationRepository;

    public Slot toSlot(SlotRequest slotRequest) {
        return Slot.builder()
                .id(slotRequest.id())
                .slotNumber(slotRequest.slotNumber())
                .isFastCharger(slotRequest.isFastCharger())
                .status(slotRequest.status())
                .availableHour(slotRequest.availableHour())
                .pricePerHour(slotRequest.pricePerHour())
                .station(Station.builder()
                        .id(slotRequest.stationId())
                        .build()
                )
                .build();
    }

    public SlotResponse toSlotResponse(Slot slot) {
        return new SlotResponse(
                slot.getId(),
                slot.getSlotNumber(),
                slot.getIsFastCharger(),
                slot.getStatus(),
                slot.getAvailableHour(),
                slot.getPricePerHour(),
                slot.getStation().getId(),
                slot.getStation().getName(),
                slot.getStation().getStatus()
        );
    }
}

