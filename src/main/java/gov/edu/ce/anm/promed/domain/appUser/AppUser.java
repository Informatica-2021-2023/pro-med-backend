package gov.edu.ce.anm.promed.domain.appUser;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import gov.edu.ce.anm.promed.domain.admin.Admin;
import gov.edu.ce.anm.promed.domain.client.Client;
import gov.edu.ce.anm.promed.domain.doctor.Doctor;
import gov.edu.ce.anm.promed.api.common.CustomInstantDeserializer;
import gov.edu.ce.anm.promed.api.common.CustomInstantSerializer;

import jakarta.persistence.*;

import javax.validation.constraints.*;

import lombok.*;

import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Admin.class, name = "Admin"),
        @JsonSubTypes.Type(value = Client.class, name = "Client"),
        @JsonSubTypes.Type(value = Doctor.class, name = "Doctor")
})
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
    @JsonSerialize(using = CustomInstantSerializer.class)
    @JsonDeserialize(using = CustomInstantDeserializer.class)
    private LocalDate birthDate;

    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    @NotBlank
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
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
