package gov.edu.ce.anm.promed.domain.model;

import jakarta.persistence.*;

import lombok.*;

import javax.validation.constraints.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank
    private String state;

    @Column
    @NotBlank
    private String city;

    @Column
    @NotBlank
    private String street;

    @Column
    @NotBlank
    private String neighborhood;

    @Column
    @NotNull
    private Integer houseNumber;

}
