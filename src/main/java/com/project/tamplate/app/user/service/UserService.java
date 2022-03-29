package com.project.tamplate.app.user.service;

import com.project.tamplate.app.user.entity.User;
import com.project.tamplate.app.user.resource.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;

    public User findUser(Long id){

        return userRepository.findTop1ById(id);
    }

}
