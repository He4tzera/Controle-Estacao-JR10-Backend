package com.estacaojr10.api.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BraceletDto {
    private String name;
    private String cpfCnpj;
    private String number;
    private Date createdAt;
    private Date expiredAt;
    private String paymentMethod;
}