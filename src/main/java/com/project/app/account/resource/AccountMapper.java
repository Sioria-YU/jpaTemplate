package com.project.app.account.resource;


import com.project.app.account.entity.Account;
import com.project.common.EntityMapper;
import com.project.app.account.dto.AccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper extends EntityMapper<AccountDto.Response, Account> {

    AccountMapper mapper = Mappers.getMapper(AccountMapper.class);

    @Override
    AccountDto.Response toDto(final Account user);

}
