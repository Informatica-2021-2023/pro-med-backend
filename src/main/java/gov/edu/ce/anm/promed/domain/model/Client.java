package gov.edu.ce.anm.promed.domain.model;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client extends AppUser{

    @OneToOne(cascade = CascadeType.ALL)
    private MedicalHistoric medicalHistoric;
}
