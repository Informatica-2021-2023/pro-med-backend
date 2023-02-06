package gov.edu.ce.anm.promed.domain.model;

import jakarta.persistence.*;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalHistoric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank
    private String bloodType;

    @Column
    @NotBlank
    private String prescriptionDrugs;

    @Column
    @NotBlank
    private String drugAllergies;

    @Column
    @NotBlank
    private String hospitalizationHistoric;

    @Column
    @NotBlank
    private String surgeriesHistoric;

    @Column
    @NotBlank
    private String priorDiseases;

    @Column
    @NotBlank
    private String extraNotes;

}
