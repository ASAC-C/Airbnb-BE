package acac.airbnb.be.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ResultDto<T> {
    private boolean isSuccess;
    private String errorMessage;
    private T object;

    public static <T> ResultDto<T> success(T object) {
        return new ResultDto<T>(true, null, object);
    }
    public static ResultDto<Void> failed(String message) {
        return new ResultDto<Void>(false, message, null);
    }


}
