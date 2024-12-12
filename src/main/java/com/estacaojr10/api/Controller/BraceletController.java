package com.estacaojr10.api.Controller;

import com.estacaojr10.api.Dto.BraceletDto;
import com.estacaojr10.api.Dto.BraceletWithHistory;
import com.estacaojr10.api.Services.BraceletServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<List<BraceletDto>> getBracelet(
            @RequestParam(defaultValue = "0") int page, // página inicial, padrão é 0
            @RequestParam(defaultValue = "10") int size // número de itens por página, padrão é 10
    ) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        List<BraceletDto> braceletDtos = braceletServices.findBracelet(pageable);
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
    @Transactional
    @PostMapping("")
    public ResponseEntity<BraceletWithHistory> createBraceletWithHistory(@RequestBody BraceletWithHistory request) {
        BraceletWithHistory createdBracelet = braceletServices.createBraceletWithHistory(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBracelet);
    }
    @Transactional
    @PutMapping("")
    public ResponseEntity<BraceletWithHistory> EditBraceletWithHistory(@RequestBody BraceletWithHistory request) {
        BraceletWithHistory editedBracelet = braceletServices.createBraceletWithHistory(request);
        return ResponseEntity.status(HttpStatus.OK).body(editedBracelet);
    }


}
