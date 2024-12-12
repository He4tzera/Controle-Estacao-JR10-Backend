package com.estacaojr10.api.Entities.Bracelet;

import com.estacaojr10.api.Entities.BraceletHistory.BraceletHistory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "Bracelet")
public class Bracelet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "Userid")
    private String userId;

    @Column(name = "Clientid")
    private String clientId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "braceletid", referencedColumnName = "id")
    private List<BraceletHistory> history = new ArrayList<>();
}
