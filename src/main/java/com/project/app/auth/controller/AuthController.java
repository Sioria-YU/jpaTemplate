package com.project.app.auth.controller;

import com.project.app.account.dto.AccountDto;
import com.project.app.auth.service.AuthService;
import com.project.secure.dto.TokenDto;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"인증"})
@RequestMapping(value = "/api/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "/signup")
    public ResponseEntity<AccountDto.Response> signup(AccountDto.Request dto){
        return ResponseEntity.ok(authService.signup(dto));
    }

    @GetMapping(value = "/auth")
    public ResponseEntity<TokenDto> auth(AccountDto.Request dto) throws Exception{
        return ResponseEntity.ok(authService.login(dto));
    }
}
