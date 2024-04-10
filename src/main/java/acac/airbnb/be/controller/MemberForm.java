package acac.airbnb.be.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberForm {

    private Long id;
    @NotNull //null일 수 없음을 명시
    @Size(min = 0, max = 10) // 값에 대한 vaildation
    @JsonProperty(value = "user_name", defaultValue = "luda", required = true) //JSON에서 필드 이름을 변경, 데이터베이스 + 프론트에서 카멜 케이스와 스네이크 케이스 혼용으로 인한 사용
    private String username;
    @JsonProperty(value = "user_last_name")
    private String userLastName;
    @JsonProperty(value = "birth_day")
    private Long birthday;
    private String email;
    private String password;

}
