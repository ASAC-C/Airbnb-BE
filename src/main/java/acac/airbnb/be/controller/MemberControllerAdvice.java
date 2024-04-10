package acac.airbnb.be.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice // 전역 예외 처리를 담당하는 Advice 명시 어노테이션
public class MemberControllerAdvice {
    /**
     * RuntimeException에 대해 중앙화
     * @param e
     * @return
     */
    @ExceptionHandler(value = RuntimeException.class)
    public ResultDto<Void> exceptionHandle1(RuntimeException e) {
        log.warn("", e);
        return ResultDto.failed(e.getMessage()); //실패에 대한 응답을 메세지로 반환
    }



    @ExceptionHandler(value = IllegalStateException.class)
    public Boolean exceptionHandle2(IllegalStateException e) {
        log.warn("", e.getMessage(), e.getStackTrace());
        return false;
    }//중복 회원 검사로 발생한 예외 catch

    @ExceptionHandler(value = NullPointerException.class)
    public Boolean exceptionHandle3(RuntimeException e) {
        log.warn("", e.getMessage(), e.getStackTrace());
        return false;
    }

}
