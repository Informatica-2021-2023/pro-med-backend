package gov.edu.ce.anm.promed.domain.doctor;

import gov.edu.ce.anm.promed.domain.appUser.AppUser;

import gov.edu.ce.anm.promed.domain.medicalAppointment.MedicalAppointment;
import jakarta.persistence.*;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor extends AppUser {

    @Enumerated(EnumType.STRING)
    private DoctorSpecialization specialization;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_identification")
    private ProfessionalIdentification professionalIdentification;

    @OneToMany(mappedBy = "id.doctor", cascade = CascadeType.ALL)
    private List<MedicalAppointment> appointments = new ArrayList<>();
}
