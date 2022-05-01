package com.weedoogift.web.controller;

import com.weedoogift.domain.service.user.UserService;
import com.weedoogift.web.dto.UserBalanceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/weedoogift/user/{idUser}/balance", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserBalanceDto> getBalance(@PathVariable(value = "idUser") Long idUser) {
        int balance = userService.computeBalance(idUser);
        return ResponseEntity.ok(UserBalanceDto.builder().balance(balance).build());
    }

}
