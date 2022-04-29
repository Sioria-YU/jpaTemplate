package com.project.app.user.entity;

import com.project.common.DefaultJpaIdWithDate;
import com.project.app.user.dto.UserDto;
import com.project.app.user.resource.UserMapper;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import javax.persistence.Entity;

@Getter
@Entity
public class User extends DefaultJpaIdWithDate {

    @ApiModelProperty(value = "사용자 아이디", required = true)
    @NotNull
    private String userId;

    @ApiModelProperty(value = "사용자 비밀번호", required = true)
    private String password;

    @ApiModelProperty(value = "사용자 이름", required = true)
    private String name;

    @ApiModelProperty(value = "사용자 성별", required = true)
    private Boolean gender;

    @ApiModelProperty(value = "사용자 전화번호", required = true)
    private String tell;

    @ApiModelProperty(value = "사용자 이메일", required = true)
    private String email;

    @ApiModelProperty(value = "사용자 우편번호", required = true)
    private String zip;

    @ApiModelProperty(value = "사용자 주소", required = true)
    private String address;

    @ApiModelProperty(value = "사용자 주소 상세", required = true)
    private String addressDetail;

    @ApiModelProperty(value = "사용자 상태", required = true)
    private Boolean status;

    @ApiModelProperty(value = "사용자 삭제여부", required = true)
    private Boolean isDelete;

    @ApiModelProperty(value = "사용자 권한타입", required = true)
    private Boolean authType;

    public UserDto.Response toResponse(){
        return UserMapper.mapper.toDto(this);
    }
}
