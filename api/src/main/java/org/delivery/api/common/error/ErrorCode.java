package org.delivery.api.common.error;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum ErrorCode implements ErrorCodeIfs{

    OK(200, 200, "성공"),

    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), 400, "잘못된 요청"),

    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), 500, "서버에러"),

    NULL_POINT(HttpStatus.INTERNAL_SERVER_ERROR.value(), 512, "Null Point")
    ;
    private final Integer httpStatusCode;

    private final Integer errorCode;

    private final String errorMessage;

    @Override
    public Integer getHttpStatusCode() {
        return this.httpStatusCode;
    }

    @Override
    public Integer getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }
}
