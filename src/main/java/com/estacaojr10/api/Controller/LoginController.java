package com.estacaojr10.api.Controller;

import com.estacaojr10.api.Dto.LoginResponse;
import com.estacaojr10.api.Dto.Login.LoginRequest;
import com.estacaojr10.api.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        Optional<LoginResponse> loginResponse = userServices.findByEmailAndPassword(request.email(), request.password());

        if (loginResponse.isPresent())
            return ResponseEntity.ok(loginResponse.get());
        else
            return ResponseEntity.badRequest().build();
    }
}
