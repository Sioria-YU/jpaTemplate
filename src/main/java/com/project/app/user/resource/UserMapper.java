package com.project.app.user.resource;


import com.common.EntityMapper;
import com.project.app.user.dto.UserDto;
import com.project.app.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper extends EntityMapper<UserDto.Response, User> {

    UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Override
    UserDto.Response toDto(final User user);

}
