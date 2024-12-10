package dev.berke.app.slot;

import dev.berke.app.station.Station;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Slot {

    @Id
    @GeneratedValue
    private Integer id;
    
    private Integer slotNumber;
    private Boolean isFastCharger;

    @Enumerated(EnumType.STRING)
    private SlotStatus status;

    private double availableHour;
    private BigDecimal pricePerHour;

    @ManyToOne
    @JoinColumn(name = "stationId", referencedColumnName = "id")
    private Station station;
}
