package com.estacaojr10.api.Entities.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {

    Optional<Client> findBycpfCnpj(String cpfCnpj);

    Optional<Client> findByNameContainingIgnoreCase(String name);

    Client findAllById(String id);
}
