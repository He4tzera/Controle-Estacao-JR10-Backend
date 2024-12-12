package com.estacaojr10.api.Services;

import com.estacaojr10.api.Dto.ClientRequest;
import com.estacaojr10.api.Entities.Client.Client;
import com.estacaojr10.api.Entities.Client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientServices {

    @Autowired
    private ClientRepository clientRepository;
    public Client getClientById(String Id) {
        return clientRepository.findAllById(Id);
    }

    public Page<Client> getClient(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    public Client getClientByCpfCnpj(String cpfCnpj) {
        return clientRepository.findBycpfCnpj(cpfCnpj).orElse(null);
    }

    public Page<Client> getClientByName(String name, Pageable pageable) {
        // Exemplo de implementação usando Spring Data JPA
        return clientRepository.findByNameContaining(name, pageable);
    }

    public Client postClient(ClientRequest clientRequest){
       return clientRepository.save(new Client(clientRequest));
    }

}
