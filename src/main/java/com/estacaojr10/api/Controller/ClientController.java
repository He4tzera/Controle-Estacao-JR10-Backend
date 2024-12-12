package com.estacaojr10.api.Controller;

import com.estacaojr10.api.Dto.ClientRequest;
import com.estacaojr10.api.Entities.Client.Client;
import com.estacaojr10.api.Services.ClientServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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
    public ResponseEntity<Page<Client>> getClient(@RequestParam(required = false) String cpfCnpj,
                                                     @RequestParam(required = false) String name,
                                                     @RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "10") int size) {
        Page<Client> clients;
        if (cpfCnpj != null) {
            Client client = clientServices.getClientByCpfCnpj(cpfCnpj);
            List<Client> clientList = client != null ? List.of(client) : List.of();
            clients = new PageImpl<>(clientList, PageRequest.of(page, size), clientList.size());
        } else if (name != null) {
            clients = clientServices.getClientByName(name, PageRequest.of(page, size));
        } else {
            clients = clientServices.getClient(PageRequest.of(page, size));
        }
        return clients.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(clients);
    }

    @PostMapping("/")
    public ResponseEntity<Client> postClient(@RequestBody @Valid ClientRequest clientRequest) {
        Client createdClient = clientServices.postClient(clientRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClient);
    }
}
