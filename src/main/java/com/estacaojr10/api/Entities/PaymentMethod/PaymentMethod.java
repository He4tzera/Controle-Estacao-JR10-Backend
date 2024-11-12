package com.estacaojr10.api.Entities.PaymentMethod;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PaymentMethod {
    CreditCard(1, "Cartão de Credito"),
    DebitCard(2, "Cartão de Debito"),
    Pix(3, "Pix"),
    Invoice(4, "Boleto"),
    Gympass(5, "Gympass"),
    Totalpass(6,"Totalpass"),
    Cash(7,"Dinheiro");

    private int id;
    private String description;
}
