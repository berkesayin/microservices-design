package dev.berke.app.station;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StationMapper {

    public Station toStation(StationRequest stationRequest) {
        return Station.builder()
                .id(stationRequest.id())
                .name(stationRequest.name())
                .status(stationRequest.status())
                .slots(new ArrayList<>())  // Initialize an empty list for slots
                .build();
    }
}
