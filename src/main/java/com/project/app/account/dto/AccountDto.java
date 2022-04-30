package com.project.app.account.dto;

import lombok.Data;

public class AccountDto {

    @Data
    public static class Response {
        String userId;

//        String password;

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

    @Data
    public static class Create {
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
