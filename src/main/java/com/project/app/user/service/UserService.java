package com.project.app.user.service;

import com.project.app.user.dto.UserDto;
import com.project.app.user.entity.UserDetail;
import com.project.app.user.resource.UserRepository;
import com.project.app.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;

    public UserDto.Response findUser(Long id){
        User user = userRepository.findById(id).orElseThrow(NullPointerException::new);

        return user.toResponse();
    }

    public UserDetails findUserByUserId(String userId) {
        UserDetail userDetail = new UserDetail();
        User user = userRepository.findByUserId(userId).orElseThrow(NullPointerException::new);

        userDetail.setUsername(user.getUserId());

        return userDetail;
    }
}
