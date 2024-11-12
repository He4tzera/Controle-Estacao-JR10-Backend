package com.estacaojr10.api.Controller;

import com.estacaojr10.api.Dto.BraceletDto;
import com.estacaojr10.api.Services.BraceletServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/bracelet")
public class BraceletController {

    @Autowired
    BraceletServices braceletServices;
    @GetMapping("")
    public ResponseEntity<List<BraceletDto>> getBracelet() {
        List<BraceletDto> braceletDtos = braceletServices.findBracelet();
        if (braceletDtos == null || braceletDtos.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(braceletDtos);
    }

    @GetMapping("/{number}")
    public ResponseEntity<List<BraceletDto>> getBraceletByNumber(@PathVariable String number) {
        List<BraceletDto> braceletDtos = braceletServices.findBraceletDetails(number);
        if (braceletDtos == null || braceletDtos.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(braceletDtos);
    }

    @PostMapping("")
    public ResponseEntity<BraceletDto> createBraceletWithHistory(@RequestBody BraceletRequest request) {
        BraceletDto createdBracelet = braceletServices.createBraceletWithHistory(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBracelet);
    }


}
