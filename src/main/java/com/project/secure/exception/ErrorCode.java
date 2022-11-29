package com.project.secure.exception;

public enum ErrorCode {

    INDEX_NOT_FOUND(1001, "인덱스가 존재하지 않습니다."),
    BOARD_NOT_FOUND(1002, "게시글을 찾을 수 없습니다.");

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

    public int getCode(){
        return  this.code;
    }

}
