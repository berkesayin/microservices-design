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
public class Address {

    private String district;
    private String streetAddress;
    private String city;
    private String zipcode;
    private String state;
    private String country;
}
