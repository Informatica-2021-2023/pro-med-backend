package gov.edu.ce.anm.promed.domain.model;

import jakarta.persistence.*;

import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalAppointmentPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
