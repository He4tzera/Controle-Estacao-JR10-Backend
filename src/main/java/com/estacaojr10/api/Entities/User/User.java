package com.estacaojr10.api.Entities.User;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Email", unique = true)
    @Email
    private String email;
    @Column(name = "Password")
    private String password;
    @Column(name = "Usertypeid")
    @Enumerated(EnumType.ORDINAL)
    private UserType userTypeId;
    @Column(name = "Createdat")
    private LocalDateTime createdAt;
    @Column(name = "Blockedat")
    private LocalDateTime blockedAt;
}
