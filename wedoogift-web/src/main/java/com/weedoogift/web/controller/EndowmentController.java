package com.weedoogift.web.controller;

import com.weedoogift.domain.service.endowment.EndowmentService;
import com.weedoogift.web.dto.EndowmentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequiredArgsConstructor
public class EndowmentController {

    private final EndowmentService endowmentService;

    @Transactional
    @PostMapping(value = "/weedoogift/company/{idCompany}/user/{idUser}/gift", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Void> distributeGift(@PathVariable Long idCompany, @PathVariable Long idUser, @RequestBody EndowmentDto endowmentDto) {
        endowmentService.distributeGift(idCompany, idUser, endowmentDto.getAmount());
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PostMapping(value = "/weedoogift/company/{idCompany}/user/{idUser}/meal", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Void> distributeMeal(@PathVariable Long idCompany, @PathVariable Long idUser, @RequestBody EndowmentDto endowmentDto) {
        endowmentService.distributeMeal(idCompany, idUser, endowmentDto.getAmount());
        return ResponseEntity.noContent().build();
    }

}
