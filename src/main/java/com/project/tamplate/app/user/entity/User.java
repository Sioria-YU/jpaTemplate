package com.project.tamplate.app.user.entity;

import com.common.DefaultJpaIdWithDate;
import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.Entity;

@Data
@Entity
public class User extends DefaultJpaIdWithDate {

    @NotNull
    @Comment("사용자 아아디")
    String userId;

    @Comment("사용자 비밀번호")
    String password;

    @Comment("사용자 이름")
    String name;

    @Comment("사용자 성별")
    Boolean gender;

    @Comment("사용자 전화번호")
    String tell;

    @Comment("사용자 이메일")
    String email;

    @Comment("사용자 우편번호")
    String zip;

    @Comment("사용자 주소")
    String address;

    @Comment("사용자 주소 상세")
    String addressDetail;

    @Comment("사용자 상태")
    Boolean status;

    @Comment("사용자 삭제여부")
    Boolean isDelete;

    @Comment("사용자 권한타입")
    Boolean authType;


}
