package gov.edu.ce.anm.promed.domain.client;

import gov.edu.ce.anm.promed.domain.client.Client;
import gov.edu.ce.anm.promed.domain.client.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Transactional
    public Optional<Client> getClientById(UUID id) {
        return clientRepository.findById(id);
    }

    @Transactional
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Transactional
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    @Transactional
    public void deleteClientById(UUID id) {
        clientRepository.deleteById(id);
    }
}
