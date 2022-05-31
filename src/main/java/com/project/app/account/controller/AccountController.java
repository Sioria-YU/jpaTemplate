package com.project.app.account.controller;

import com.project.app.account.dto.AccountDto;
import com.project.app.account.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"사용자"})
@RequestMapping(value = "/api/account")
@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService userService;

    @ApiOperation(value = "사용자 조회", notes = "사용자 조회 api")
    @GetMapping(value="/{id}")
    public ResponseEntity<AccountDto.Response> getUsers(@PathVariable Long id){
        return ResponseEntity.ok(userService.findUser(id));
    }

    @ApiOperation(value = "사용자 정보 아이디로 조회", notes = "사용자 조회 api")
    @GetMapping(value="/{userId}")
    public ResponseEntity<AccountDto.Response> getUserInfo(@PathVariable String userId){
        return ResponseEntity.ok(userService.findUserByUserId(userId));
    }

}
