package gov.edu.ce.anm.promed.domain.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor extends AppUser{

    private String specialization;
}
