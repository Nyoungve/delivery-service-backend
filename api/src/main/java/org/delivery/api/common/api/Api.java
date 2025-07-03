package org.delivery.api.common.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.error.ErrorCodeIfs;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Api<T> {
    private Result result;
    private T body;

    public static <T> Api<T> OK(T body){
        return Api.<T>builder()
                .result(Result.OK())
                .body(body)
                .build();
    }

    public static Api<Object> ERROR(Result result){
        return Api.<Object>builder()
                .result(result)
                .build();
    }

    public static Api<Object> ERROR(ErrorCodeIfs errorCodeIfs){
        return Api.<Object>builder()
                .result(Result.ERROR(errorCodeIfs))
                .build();
    }

    public static Api<Object> ERROR(ErrorCodeIfs errorCodeIfs, Throwable tx){
        return Api.<Object>builder()
                .result(Result.ERROR(errorCodeIfs, tx))
                .build();
    }

    public static Api<Object> ERROR(ErrorCodeIfs errorCodeIfs, String description){
        return Api.<Object>builder()
                .result(Result.ERROR(errorCodeIfs, description))
                .build();
    }

}
