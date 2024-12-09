package dev.berke.app.charging_station;

import java.util.List;

import lombok.AllArgsConstructor;
// import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
// @Builder
@Getter
@Setter
@Document(collection = "charging_stations")
public class ChargingStation {

    @Id
    private String id;
    private String name;
    private List<Connector> connectors;
    private String formattedAddress;
    private Address addressComponents;
    private double latitude;
    private double longitude;
    private String placeLink;
    private String phoneNumber;
    private OpeningHours openingHours;
    private double rating;
    private int reviewCount;
    private String website;
    private String photo;
    private String googlePlaceId;
    private String googleCid;
}

