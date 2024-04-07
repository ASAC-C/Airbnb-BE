package acac.airbnb.be.domain;

import acac.airbnb.be.controller.MemberForm;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

    private Long id;

    private String userName;

    private String userLastName;

    private Long birthDay;

    private String email;

    private String password;

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
