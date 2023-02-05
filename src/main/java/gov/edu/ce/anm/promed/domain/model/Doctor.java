package gov.edu.ce.anm.promed.domain.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor extends AppUser{

    private String specialization;
}
