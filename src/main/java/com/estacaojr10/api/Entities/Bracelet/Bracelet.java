package com.estacaojr10.api.Entities.Bracelet;

import com.estacaojr10.api.Entities.BraceletHistory.BraceletHistory;
import com.estacaojr10.api.Entities.Client.Client;
import com.estacaojr10.api.Entities.User.User;
import jakarta.persistence.*;
import lombok.*;

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
    @ManyToOne
    @JoinColumn(name = "Userid")
    private User userId;
    @ManyToOne
    @JoinColumn(name = "Clientid")
    private Client clientId;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "braceletid", referencedColumnName = "id")
    private List<BraceletHistory> history = new ArrayList<>();
}
