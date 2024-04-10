package acac.airbnb.be.data.dto;

import acac.airbnb.be.enums.ResType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResultDTO {
    private String message;
    private String resType;

    /**
     * task : 성공 시 클라이언트로 보내줄 ResultDTO<T> 객체
     * param
     * - dto : 값이 채워진 DTO 객체
     * - message : 성공 메시지
     */
    public ResultDTO success(String message) {
        this.message = message;
        this.resType = ResType.SUCCESS.name();
        return this;
    }

    /**
     * task : 실패 시 클라이언트로 보내줄 ResultDTO<T> 객체
     * param
     * - resType : 실패 타입
     * - message : 실패 메시지
     */
    public static ResultDTO failed(ResType resType, String message) {
        System.out.println(resType.name() + " " + message);
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.message = message;
        resultDTO.resType = resType.name();
        return resultDTO;
    }
}