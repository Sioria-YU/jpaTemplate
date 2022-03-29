package com.project.tamplate.app.user.dto;

import lombok.Getter;
import lombok.Setter;

public class UserDto {

    @Getter
    public class Response {
        String userId;

        String password;

        String name;

        Boolean gender;

        String tell;

        String email;

        String zip;

        String address;

        String addressDetail;

        Boolean status;

        Boolean isDelete;

        Boolean authType;
    }

    @Setter
    public class Create {
        String userId;

        String password;

        String name;

        Boolean gender;

        String tell;

        String email;

        String zip;

        String address;

        String addressDetail;

        Boolean status;

        Boolean isDelete;

        Boolean authType;
    }
}
