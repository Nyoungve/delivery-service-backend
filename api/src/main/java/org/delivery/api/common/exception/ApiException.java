package org.delivery.api.common.exception;

import lombok.Getter;
import org.delivery.api.common.error.ErrorCodeIfs;

@Getter
public class ApiException extends RuntimeException implements ApiExceptionIfs{

    private final ErrorCodeIfs errorCodeIfs;

    private final String errorCodeMessage;

    public ApiException(ErrorCodeIfs errorCodeIfs){
        super(errorCodeIfs.getErrorMessage());
        this.errorCodeIfs = errorCodeIfs;
        this.errorCodeMessage = errorCodeIfs.getErrorMessage();
    }

    public ApiException(ErrorCodeIfs errorCodeIfs, String errorCodeMessage){
        super(errorCodeMessage);
        this.errorCodeIfs = errorCodeIfs;
        this.errorCodeMessage = errorCodeMessage;
    }

    public ApiException(ErrorCodeIfs errorCodeIfs, Throwable tx){
        super(tx);
        this.errorCodeIfs = errorCodeIfs;
        this.errorCodeMessage = errorCodeIfs.getErrorMessage();
    }

    public ApiException(ErrorCodeIfs errorCodeIfs, Throwable tx, String errorCodeMessage){
        super(tx);
        this.errorCodeIfs = errorCodeIfs;
        this.errorCodeMessage = errorCodeMessage;
    }
}
