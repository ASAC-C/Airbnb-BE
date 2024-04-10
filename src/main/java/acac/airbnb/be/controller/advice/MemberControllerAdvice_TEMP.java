package acac.airbnb.be.controller.advice;

// Slf4j : 로깅 기능을 추상화하는 Java 라이브러리

import acac.airbnb.be.controller.member.MemberController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(basePackageClasses = MemberController.class)
public class MemberControllerAdvice_TEMP {

//region 반환형으로 Class 타입으로 지정한 함수 형태
    /*
    @ExceptionHandler(value = RuntimeException.class)
    public ResultDto<Void> handeleRuntimeException(RuntimeException e) {
        log.warn("", e);
        return ResultDto.failed(e.getMessage());
    }
    */
//endregion

    @ExceptionHandler(value = RuntimeException.class)
    public String handeleRuntimeException(RuntimeException e) {
        e.printStackTrace();
        return e.getMessage();
    }

    @ExceptionHandler(value = ArithmeticException.class)
    public String handeleArithmeticException(ArithmeticException e) {
        e.printStackTrace();
        return e.getMessage();
    }

    @ExceptionHandler(value = NullPointerException.class)
    public String handeleNullPointerException(NullPointerException e) {
        e.printStackTrace();
        return e.getMessage();
    }
}