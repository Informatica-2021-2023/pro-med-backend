package gov.edu.ce.anm.promed.repositories;

import gov.edu.ce.anm.promed.domain.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, UUID> {

}
