package dev.berke.app.station;

import dev.berke.app.slot.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Integer> {
}