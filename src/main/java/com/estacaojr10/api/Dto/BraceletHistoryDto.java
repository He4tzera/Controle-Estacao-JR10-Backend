package com.estacaojr10.api.Dto;

import com.estacaojr10.api.Entities.PaymentMethod.PaymentMethod;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BraceletHistoryDto {
   @NotNull
   private String number;
   private Float price;
   @NotNull
   private PaymentMethod paymentMethod;
   private Float discount;
   @NotNull
   private Date createdAt;
   @NotNull
   private Date expiredAt;
   private Date deletedAt;

}
