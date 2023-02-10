package gov.edu.ce.anm.promed.domain.model;

import jakarta.persistence.*;

import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client extends AppUser{

    @OneToOne(cascade = CascadeType.ALL)
    private MedicalHistoric medicalHistoric;

    @OneToMany(mappedBy = "id.client", cascade = CascadeType.ALL)
    private List<MedicalAppointment> appointments;
}
