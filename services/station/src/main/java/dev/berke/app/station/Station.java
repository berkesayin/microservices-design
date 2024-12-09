package dev.berke.app.station;

import dev.berke.app.slot.Slot;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Station {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @Enumerated(EnumType.STRING)
    private StationStatus status;

    @OneToMany(mappedBy = "station", cascade = CascadeType.REMOVE)
    private List<Slot> slots;
}
