package com.project.tamplate.app.user.entity;

import com.common.DefaultJpaIdWithDate;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;

@Getter
@Entity
public class User extends DefaultJpaIdWithDate {

    @ApiModelProperty(value = "사용자 아이디", required = true)
    @NotNull
    String userId;

    @ApiModelProperty(value = "사용자 비밀번호", required = true)
    String password;

    @ApiModelProperty(value = "사용자 이름", required = true)
    String name;

    @ApiModelProperty(value = "사용자 성별", required = true)
    Boolean gender;

    @ApiModelProperty(value = "사용자 전화번호", required = true)
    String tell;

    @ApiModelProperty(value = "사용자 이메일", required = true)
    String email;

    @ApiModelProperty(value = "사용자 우편번호", required = true)
    String zip;

    @ApiModelProperty(value = "사용자 주소", required = true)
    String address;

    @ApiModelProperty(value = "사용자 주소 상세", required = true)
    String addressDetail;

    @ApiModelProperty(value = "사용자 상태", required = true)
    Boolean status;

    @ApiModelProperty(value = "사용자 삭제여부", required = true)
    Boolean isDelete;

    @ApiModelProperty(value = "사용자 권한타입", required = true)
    Boolean authType;


}
