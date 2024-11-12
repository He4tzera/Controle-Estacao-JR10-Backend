package com.estacaojr10.api.Controller;

import com.estacaojr10.api.Entities.User.User;
import com.estacaojr10.api.Login.LoginRequest;
import com.estacaojr10.api.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserServices userServices;

    @PostMapping("")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        Optional<User> user = userServices.findByEmailAndPassword(request.email(), request.password());

        if (user.isPresent())
            return ResponseEntity.ok("Login successful");
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");

    }
}
