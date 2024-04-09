package acac.airbnb.be.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor// 어노테이션은 파라미터가 없는 디폴트 생성자를 자동으로 생성한다. 이 어노테이션을 사용하면, 클래스에 명시적으로 선언된 생성자가 없더라도 인스턴스를 생성할 수 있다.
public class ResponseDto {

    private String result;
    private String msg;
    private Object obj;

    public ResponseDto(String result, String msg, Object obj) {
        this.result = result;
        this.msg = msg;
        this.obj = obj;
    }
}