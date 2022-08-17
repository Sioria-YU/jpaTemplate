package com.project.app.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AccountDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Reuqest {
        String userId;
        String password;


        public UsernamePasswordAuthenticationToken toAuthentication() {
            return new UsernamePasswordAuthenticationToken(userId, password);
        }
    }

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

    @Data
    public static class Update {
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
