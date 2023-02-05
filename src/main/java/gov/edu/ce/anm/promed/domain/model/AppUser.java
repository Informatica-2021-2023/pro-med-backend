package gov.edu.ce.anm.promed.domain.model;

import gov.edu.ce.anm.promed.domain.enums.AppUserRole;
import gov.edu.ce.anm.promed.domain.enums.Gender;
import jakarta.persistence.*;

import javax.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AppUser {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column
    @NotBlank
    private String email;

    @Column
    @NotBlank
    private String password;

    @Column
    @NotBlank
    private String fullName;

    @Column
    @NotNull
    private Date birthDate;

    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    @NotBlank
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @Column
    @NotBlank
    private String cpf;

    @Column
    @NotBlank
    private String rg;

    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private AppUserRole role;

}
