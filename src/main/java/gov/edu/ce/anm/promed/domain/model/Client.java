package gov.edu.ce.anm.promed.domain.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client extends AppUser{

    private MedicalHistoric medicalHistoric;
}
