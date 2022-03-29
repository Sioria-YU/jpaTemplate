package com.project.tamplate.app.user.controller;

import com.project.tamplate.app.user.entity.User;
import com.project.tamplate.app.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value="/{id}")
    public ResponseEntity<User> getUsers(@PathVariable Long id){
        return ResponseEntity.ok(userService.findUser(id));
    }
}
