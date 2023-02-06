package gov.edu.ce.anm.promed.repositories;

import gov.edu.ce.anm.promed.domain.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
