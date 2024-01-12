package org.prog.db.tables;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.prog.web.dto.PersonDto;

import javax.persistence.*;

//150,Granum,Kristupas,male,Mr,NO

@Entity
@Table(name = "Persons")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//List<Persons>
public class Persons {

    @Id
    @Column(name = "PersonID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;//150

    @Column(name = "LastName")
    private String lastName;//Granum

    @Column(name = "FirstName")
    private String firstName;//Kristupas

    @Column(name = "Title")
    private String title;//Mr

    @Column(name = "Gender")
    private String gender;//male

    @Column(name = "Nat")
    private String nat;//NO

    public static Persons fromDto(PersonDto dto) {
        return Persons.builder()
                .gender(dto.getGender())
                .nat(dto.getNat())
                .title(dto.getName().getTitle())
                .firstName(dto.getName().getFirst())
                .lastName(dto.getName().getLast())
                .build();
    }
}