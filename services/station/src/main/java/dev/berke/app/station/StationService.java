package dev.berke.app.station;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StationService {

    private final StationRepository stationRepository;
    private final StationMapper stationMapper;

    public Integer createStation(StationRequest stationRequest) {
        var station = stationMapper.toStation(stationRequest);
        return stationRepository.save(station).getId();
    }
}
