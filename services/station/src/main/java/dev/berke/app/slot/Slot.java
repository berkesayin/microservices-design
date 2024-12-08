package dev.berke.app.slot;

import dev.berke.app.station.Station;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    private Integer id;
    private Integer slotNumber;
    private Boolean isFastCharger;

    @Enumerated(EnumType.STRING)
    private SlotStatus status;

    private double availableHour;
    private BigDecimal pricePerHour;

    @ManyToOne
    @JoinColumn
    private Station station;
}
