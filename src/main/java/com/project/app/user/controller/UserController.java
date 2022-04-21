package com.project.app.user.controller;

import com.project.app.user.dto.UserDto;
import com.project.app.user.entity.User;
import com.project.app.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = {"사용자"})
@RequestMapping(value = "/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "사용자 조회", notes = "사용자 조회 api")
    @GetMapping(value="/{id}")
    public ResponseEntity<UserDto.Response> getUsers(@PathVariable Long id){
        return ResponseEntity.ok(userService.findUser(id));
    }
}
