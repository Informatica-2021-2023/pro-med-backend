package gov.edu.ce.anm.promed.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalHistoric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bloodType;

    private List<String> prescriptionDrugs;

    private List<String> allergies;

    private List<String> priorHospitalization;

    private List<String> psychiatricIllnesses;

    private List<String> chronicDiseases;

    private List<String> treatments;
}
