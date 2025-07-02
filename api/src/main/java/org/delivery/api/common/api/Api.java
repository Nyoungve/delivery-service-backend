package org.delivery.api.common.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Api<T> {
    private Result result;
    private T body;

    public static <T> Api<T> Ok(T body){
        return Api.<T>builder()
                .result(Result.Ok())
                .body(body)
                .build();
    }
}
