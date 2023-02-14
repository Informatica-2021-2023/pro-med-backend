package gov.edu.ce.anm.promed.domain.model;

import gov.edu.ce.anm.promed.domain.enums.DoctorSpecialization;

import jakarta.persistence.*;

import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor extends AppUser{

    @Enumerated(EnumType.STRING)
    private DoctorSpecialization specialization;

    private ProfessionalIdentification professionalIdentification;

    @OneToMany(mappedBy = "id.doctor", cascade = CascadeType.ALL)
    private List<MedicalAppointment> appointments;
}
