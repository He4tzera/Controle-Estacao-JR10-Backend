package com.estacaojr10.api.Services;

import com.estacaojr10.api.Dto.ClientRequest;
import com.estacaojr10.api.Entities.Client.Client;
import com.estacaojr10.api.Entities.Client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServices {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClient() {
        return clientRepository.findAll();
    }

    public Client getClientByCpfCnpj(String cpfCnpj) {
        return clientRepository.findBycpfCnpj(cpfCnpj).orElse(null);
    }

    public Client getClientByName(String name) {
        return clientRepository.findByNameContainingIgnoreCase(name).orElse(null);
    }

    public Client postClient(ClientRequest clientRequest){
       return clientRepository.save(new Client(clientRequest));
    }

    public Client getClientById(String Id) {
        return clientRepository.findAllById(Id);
    }
}
