package gov.edu.ce.anm.promed.domain.model;

import jakarta.persistence.*;

import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor extends AppUser{

    private String specialization;

    @OneToMany(mappedBy = "id.doctor", cascade = CascadeType.ALL)
    private List<MedicalAppointment> appointments;
}
