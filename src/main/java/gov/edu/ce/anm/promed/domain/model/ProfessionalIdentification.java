package gov.edu.ce.anm.promed.domain.model;

import gov.edu.ce.anm.promed.domain.enums.ProfessionalIdentificationType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import javax.validation.constraints.NotBlank;

public class ProfessionalIdentification {

    @NotBlank
    private String registrationCode;

    @Enumerated(EnumType.STRING)
    private ProfessionalIdentificationType identificationType;
}
