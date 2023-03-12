package gov.edu.ce.anm.promed.domain.client;

import gov.edu.ce.anm.promed.domain.appUser.AppUser;
import gov.edu.ce.anm.promed.domain.medicalAppointment.MedicalAppointment;
import jakarta.persistence.*;

import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client extends AppUser {

    @OneToOne(cascade = CascadeType.ALL)
    private MedicalHistoric medicalHistoric;

    @OneToMany(mappedBy = "id.client", cascade = CascadeType.ALL)
    private List<MedicalAppointment> appointments;
}
