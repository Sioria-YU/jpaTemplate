package com.project.app.account.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AccountDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Request {
        @ApiModelProperty(value = "아이디")
        String userId;

        @ApiModelProperty(value = "비밀번호")
        String password;

        @ApiModelProperty(value = "이름")
        String name;

        @ApiModelProperty(value = "성별")
        Boolean gender;

        @ApiModelProperty(value = "전화번호")
        String tell;

        @ApiModelProperty(value = "이메일")
        String email;

        @ApiModelProperty(value = "우편번호")
        String zip;

        @ApiModelProperty(value = "주소")
        String address;

        @ApiModelProperty(value = "주소 상세")
        String addressDetail;

        @ApiModelProperty(value = "상태")
        Boolean status;

        @ApiModelProperty(value = "삭제여부")
        Boolean isDelete;

        @ApiModelProperty(value = "권한구분")
        Boolean authType;

        public UsernamePasswordAuthenticationToken toAuthentication() {
            return new UsernamePasswordAuthenticationToken(userId, password);
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Response {
        @ApiModelProperty(value = "아이디")
        String userId;

//        @ApiModelProperty(value = "비밀번호")
//        String password;

        @ApiModelProperty(value = "이름")
        String name;

        @ApiModelProperty(value = "성별")
        Boolean gender;

        @ApiModelProperty(value = "전화번호")
        String tell;

        @ApiModelProperty(value = "이메일")
        String email;

        @ApiModelProperty(value = "우편번호")
        String zip;

        @ApiModelProperty(value = "주소")
        String address;

        @ApiModelProperty(value = "주소 상세")
        String addressDetail;

        @ApiModelProperty(value = "상태")
        Boolean status;

        @ApiModelProperty(value = "삭제여부")
        Boolean isDelete;

        @ApiModelProperty(value = "권한구분")
        Boolean authType;
    }

}
