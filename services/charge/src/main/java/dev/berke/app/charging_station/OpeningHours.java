package dev.berke.app.charging_station;

import java.util.List;
import java.util.Map;

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
public class OpeningHours {
    private Map<String, List<String>> hours;
}
