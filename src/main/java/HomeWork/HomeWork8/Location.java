package HomeWork.HomeWork8;

import HomeWork.HomeWork7.Coordinates;
import HomeWork.HomeWork7.Street;
import HomeWork.HomeWork7.Timezone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {
    private Street street;
    private String city;
    private String state;
    private String country;
    private String postcode;
    private Coordinates coordinates;
    private Timezone timezone;
}
