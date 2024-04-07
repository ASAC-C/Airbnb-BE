package acac.airbnb.be.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class MemberControllerAdvice {
    @ExceptionHandler(value = RuntimeException.class)
    public ResultDto<Void> exceptionHandle1(RuntimeException e) {
        log.warn("", e);
        return ResultDto.failed(e.getMessage());
    }

    @ExceptionHandler(value = ArithmeticException.class)
    public Boolean exceptionHandle2(RuntimeException e) {
        log.warn("", e.getMessage(), e.getStackTrace());
        return false;
    }

    @ExceptionHandler(value = NullPointerException.class)
    public Boolean exceptionHandle3(RuntimeException e) {
        log.warn("", e.getMessage(), e.getStackTrace());
        return false;
    }

}
