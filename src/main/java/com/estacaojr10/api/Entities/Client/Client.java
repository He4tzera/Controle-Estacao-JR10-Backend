package com.estacaojr10.api.Entities.Client;

import com.estacaojr10.api.Dto.ClientRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Cpfcnpj")
    private String cpfCnpj;
    private String telephone;
    @Column(name = "Postalcode")
    private String postalCode;
    private Boolean student;
    @Column(name = "Createdat")
    private Date createdAt;
    @Column(name = "Blockedat")
    private Date blockedAt;

    public Client(ClientRequest clientRequest) {
        this.id = clientRequest.id();
        this.name= clientRequest.name();
        this.cpfCnpj = clientRequest.cpfCnpj();
        this.telephone= clientRequest.telephone();
        this.postalCode= clientRequest.postalCode();
        this.student = clientRequest.student();
        this.createdAt = clientRequest.createdAt();
        this.blockedAt = clientRequest.blockedAt();
    }
}
