package org.prog.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.prog.db.tables.Persons;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDto {
    private NameDto name;
    private String gender;
    private String nat;

    public static PersonDto fromDb(Persons persons) {
        return PersonDto.builder()
                .nat(persons.getNat())
                .gender(persons.getGender())
                .name(NameDto.builder()
                        .first(persons.getFirstName())
                        .last(persons.getLastName())
                        .title(persons.getTitle())
                        .build()).build();
    }
}
