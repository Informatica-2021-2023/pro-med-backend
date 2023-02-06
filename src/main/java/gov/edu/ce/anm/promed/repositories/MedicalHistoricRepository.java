package gov.edu.ce.anm.promed.repositories;

import gov.edu.ce.anm.promed.domain.model.MedicalHistoric;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalHistoricRepository extends JpaRepository<MedicalHistoric, Long> {

}
