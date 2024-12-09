package dev.berke.app.charging_station;

import lombok.AllArgsConstructor;
// import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
// @Builder
@Getter
@Setter
public class Connector {

    private String type;
    private int total;
    private int available;
    private double kw;
    private String speed;
}
