package com.estacaojr10.api.Entities.User;

import com.estacaojr10.api.Dto.LoginResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<LoginResponse> findByEmailAndPassword(String email, String password);
}