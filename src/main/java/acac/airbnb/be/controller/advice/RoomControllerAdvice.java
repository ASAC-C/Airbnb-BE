package acac.airbnb.be.controller.advice;

import acac.airbnb.be.controller.RoomController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackageClasses = RoomController.class)
public class RoomControllerAdvice {

    @Value("${spring.profiles.active}")
    private String profile;

    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(RuntimeException e) {
        printStackTrace(e);
        return e.getMessage();
    }

    @ExceptionHandler(NullPointerException.class)
    public String handleNullPointerException(NullPointerException e) {
        printStackTrace(e);
        return e.getMessage();
    }

    /**
     * task : 예외 발생 스택 정보 출력
     */
    private void printStackTrace(Exception e) {
        if ("dev".equals(profile))
            e.printStackTrace();
    }
}