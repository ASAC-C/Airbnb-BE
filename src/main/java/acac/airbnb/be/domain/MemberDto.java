package acac.airbnb.be.domain;

import acac.airbnb.be.controller.MemberForm;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor // 생성자 자동 생성
@AllArgsConstructor // 필드에 생성자 자동 생성?
public class MemberDto {

    private Long id;

    private String userName;

    private String userLastName;

    private Long birthDay;

    private String email;

    private String password;

    /**
     * 프론트에서 사용자가 입력한 Form을 Dto로 변환
     * @param form
     * @return MemberDto 객체
     */
    public static MemberDto of(MemberForm form) {
        return new MemberDto(
                form.getId(),
                form.getUsername(),
                form.getUserLastName(),
                form.getBirthday(),
                form.getEmail(),
                form.getPassword()
        );
    }
}
