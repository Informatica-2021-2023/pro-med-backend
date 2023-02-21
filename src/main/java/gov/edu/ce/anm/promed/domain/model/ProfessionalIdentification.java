package gov.edu.ce.anm.promed.domain.model;

import gov.edu.ce.anm.promed.domain.enums.ProfessionalIdentificationType;

import jakarta.persistence.*;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionalIdentification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String registrationCode;

    @Enumerated(EnumType.STRING)
    private ProfessionalIdentificationType identificationType;
}
