package dev.berke.app.slot;

import dev.berke.app.station.Station;
import org.springframework.stereotype.Service;

@Service
public class SlotMapper {

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
}
