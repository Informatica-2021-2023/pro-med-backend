package gov.edu.ce.anm.promed.domain.doctor;

import gov.edu.ce.anm.promed.domain.doctor.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, UUID> {

}
