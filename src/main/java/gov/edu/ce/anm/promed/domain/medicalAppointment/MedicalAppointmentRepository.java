package gov.edu.ce.anm.promed.domain.medicalAppointment;

import gov.edu.ce.anm.promed.domain.medicalAppointment.MedicalAppointment;
import gov.edu.ce.anm.promed.domain.medicalAppointment.MedicalAppointmentPK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointment, MedicalAppointmentPK> {

}
