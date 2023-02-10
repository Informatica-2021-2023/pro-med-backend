package gov.edu.ce.anm.promed.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import gov.edu.ce.anm.promed.domain.enums.AppointmentType;

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
