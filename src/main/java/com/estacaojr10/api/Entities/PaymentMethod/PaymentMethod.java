package com.estacaojr10.api.Entities.PaymentMethod;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum PaymentMethod {
    Crédito(1, "Cartão de Credito"),
    Debito(2, "Cartão de Debito"),
    Pix(3, "Pix"),
    Boleto(4, "Boleto"),
    Gympass(5, "Gympass"),
    Totalpass(6,"Totalpass"),
    Dinheiro(7,"Dinheiro");

    private int id;
    private String description;
}
