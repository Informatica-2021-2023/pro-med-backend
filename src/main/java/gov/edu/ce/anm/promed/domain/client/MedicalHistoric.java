package gov.edu.ce.anm.promed.domain.client;

import jakarta.persistence.*;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalHistoric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private BloodType bloodType;

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
