package gov.edu.ce.anm.promed.repositories;

import gov.edu.ce.anm.promed.domain.model.MedicalAppointment;
import gov.edu.ce.anm.promed.domain.model.MedicalAppointmentPK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointment, MedicalAppointmentPK> {

}
