package gov.edu.ce.anm.promed.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalHistoric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bloodType;

    private String prescriptionDrugs;

    private String drugAllergies;

    private String hospitalizationHistoric;

    private String surgeriesHistoric;

    private String priorDiseases;

    private String extraNotes;

}
