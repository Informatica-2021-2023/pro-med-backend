package gov.edu.ce.anm.promed.api.admin;

import gov.edu.ce.anm.promed.domain.client.Client;
import gov.edu.ce.anm.promed.domain.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/clients/")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getClients() {
        return clientService.getClients();
    }

    @GetMapping("{id}")
    public Optional<Client> getClientById(@PathVariable UUID id) {
        return clientService.getClientById(id);
    }

    @PostMapping
    public Client saveClient(@RequestBody Client admin) {
        return clientService.saveClient(admin);
    }

    @PutMapping
    public Client updateClient(@RequestBody Client admin) {
        return clientService.updateClient(admin);
    }

    @DeleteMapping("{id}")
    public void deleteClient(@PathVariable UUID id) {
        clientService.deleteClientById(id);
    }
}
