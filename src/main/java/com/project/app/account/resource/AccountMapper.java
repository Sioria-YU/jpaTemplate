package com.project.app.account.resource;


import com.project.app.account.dto.AccountDto;
import com.project.app.account.entity.Account;
import com.project.common.CruEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper extends CruEntityMapper<Account, AccountDto.Create, AccountDto.Response, AccountDto.Update> {

    AccountMapper mapper = Mappers.getMapper(AccountMapper.class);

    @Override
    AccountDto.Response entityToResponse(final Account user);

    @Override
    Account createdToEntity(final AccountDto.Create accountDto);

    @Override
    Account updatedToEntity(final AccountDto.Update accountDto);

}
