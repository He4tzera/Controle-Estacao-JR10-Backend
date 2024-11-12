package com.estacaojr10.api.Controller;

import com.estacaojr10.api.Dto.ClientRequest;
import com.estacaojr10.api.Entities.Client.Client;
import com.estacaojr10.api.Services.ClientServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientServices clientServices;

    @GetMapping("/{Id}")
    public ResponseEntity<Client> getClientById(@PathVariable String Id ){
        Client client = clientServices.getClientById(Id);
        return ResponseEntity.ok(client);
    }

    @GetMapping("/")
    public ResponseEntity<List<Client>> getClient(@RequestParam(required = false) String cpfCnpj,
                                                  @RequestParam(required = false) String name) {
        List<Client> clients;

        if (cpfCnpj != null) {
            Client client = clientServices.getClientByCpfCnpj(cpfCnpj);
            clients = client != null ? List.of(client) : List.of();
        } else if (name != null) {
            Client client = clientServices.getClientByName(name);
            clients = client != null ? List.of(client) : List.of();
        } else
            clients = clientServices.getClient();
        return clients.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(clients);
    }
    @PostMapping("/")
    public ResponseEntity<Client> postClient(@RequestBody @Valid ClientRequest clientRequest) {
        Client createdClient = clientServices.postClient(clientRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClient);
    }
}
