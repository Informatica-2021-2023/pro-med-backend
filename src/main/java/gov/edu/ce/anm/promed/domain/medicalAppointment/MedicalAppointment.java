package gov.edu.ce.anm.promed.domain.medicalAppointment;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import lombok.*;

import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalAppointment {

    @JsonIgnore
    @EmbeddedId
    private MedicalAppointmentPK id;

    private Instant date;

    private AppointmentType type;
}
