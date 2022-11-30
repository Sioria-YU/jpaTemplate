package com.project.app.account.service;

import com.project.app.account.dto.AccountDto;
import com.project.app.account.entity.Account;
import com.project.app.account.resource.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountService {

    public final AccountRepository userRepository;

    public AccountDto.Response findUser(long id){
        Account user = userRepository.findById(id).orElseThrow(NullPointerException::new);
        return user.toResponse();
    }

    public AccountDto.Response findUserByUserId(String userId) {
        Account user = userRepository.findByUserId(userId).orElseThrow(NullPointerException::new);
        return user.toResponse();
    }

    public List<AccountDto.Response> getUserByGenderAndIsDelete(AccountDto.Request dto){
        List<Account> userList = userRepository.findAllByGenderAndIsDelete(dto.getGender(), dto.getIsDelete());

        List<AccountDto.Response> responseList = userList.stream().map(v -> v.toResponse()).collect(Collectors.toList());
        return responseList;
    }
}
