package com.estacaojr10.api.Entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum UserType {
    Admin(1, "Admin"),
    Cliente(2, "Cliente"),
    Gerente(3, "Gerente");

    private int id;
    private String description;
}
