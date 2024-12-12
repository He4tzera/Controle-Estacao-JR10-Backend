package com.estacaojr10.api.Entities.BraceletHistory;

import com.estacaojr10.api.Dto.BraceletHistoryDto;
import com.estacaojr10.api.Entities.Bracelet.Bracelet;
import com.estacaojr10.api.Entities.PaymentMethod.PaymentMethod;
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
@Table(name = "Bracelethistory")
public class BraceletHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne
    @JoinColumn(name = "Braceletid")
    private Bracelet bracelet;
    private String number;
    private Float price;
    @Column(name = "Paymentmethodid")
    @Enumerated(EnumType.ORDINAL)
    private PaymentMethod paymentMethodId;;
    private Float discount;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Createdat")
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Expiredat")
    private Date expiredAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Deletedat")
    private Date deletedAt;


    public BraceletHistory(BraceletHistoryDto dto, Bracelet bracelet) {
        this.bracelet = bracelet;  // Definindo o Bracelet associado
        this.number = dto.getNumber();
        this.price = dto.getPrice();
        this.paymentMethodId = dto.getPaymentMethod();
        this.discount = dto.getDiscount();
        this.createdAt = dto.getCreatedAt();
        this.expiredAt = dto.getExpiredAt();
        this.deletedAt = dto.getDeletedAt();
    }

}
