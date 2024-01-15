package HomeWork.HomeWork8;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    private Name name;
    private String gender;
    private String nat;
    private Location location;
}
