package dev.berke.app.charging_station;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChargingStationRepository extends MongoRepository<ChargingStation, String> {
}

