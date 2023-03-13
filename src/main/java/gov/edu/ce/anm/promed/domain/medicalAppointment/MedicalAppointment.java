package gov.edu.ce.anm.promed.domain.medicalAppointment;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

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

    @Transient
    @Enumerated(EnumType.STRING)
    private AppointmentStatus appointmentStatus;

    public AppointmentStatus getAppointmentStatus() {
        setAppointmentStatus(AppointmentStatus.SCHEDULED);
        if(date.isAfter(Instant.now())) {
            setAppointmentStatus(AppointmentStatus.PAID);
        }
        return appointmentStatus;
    }
}
