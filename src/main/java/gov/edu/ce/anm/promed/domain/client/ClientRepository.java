package gov.edu.ce.anm.promed.domain.client;

import gov.edu.ce.anm.promed.domain.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

}
