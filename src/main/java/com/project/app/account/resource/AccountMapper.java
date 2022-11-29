package com.project.app.account.resource;


import com.project.app.account.dto.AccountDto;
import com.project.app.account.entity.Account;
import com.project.common.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper
public interface AccountMapper extends EntityMapper<Account, AccountDto.Request, AccountDto.Response> {

    AccountMapper mapper = Mappers.getMapper(AccountMapper.class);

    @Override
    AccountDto.Response toResponse(final Account user);

    @Override
    Account toEntity(final AccountDto.Request accountDto);

}
