package com.estacaojr10.api.Controller;

import com.estacaojr10.api.Dto.LoginResponse;
import com.estacaojr10.api.Dto.Login.LoginRequest;
import com.estacaojr10.api.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserServices userServices;

    @GetMapping("")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        Optional<LoginResponse> loginResponse = userServices.findByEmailAndPassword(request.email(), request.password());
        return loginResponse.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
