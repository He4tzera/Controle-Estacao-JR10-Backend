package com.estacaojr10.api.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

public record ClientRequest(
        @NotNull(message = "O campo Id não pode ser nulo")
        String id,
        @NotNull(message = "O campo nome não pode ser nulo")
        @Pattern(regexp = "^[A-Za-z]+$", message = "O nome deve conter apenas letras.")
        String name,
        @NotNull(message = "O campo CPF não pode ser nulo")
        String cpfCnpj,
        @NotNull(message = "O campo Telefone não pode ser nulo")
        String telephone,
        @NotNull(message = "O campo CEP não pode ser nulo")
        String postalCode,
        @NotNull(message = "O campo estudante não pode ser nulo")
        Boolean student,
        @NotNull(message = "O campo data de criação não pode ser nulo")
        Date createdAt,
        Date blockedAt
) {}