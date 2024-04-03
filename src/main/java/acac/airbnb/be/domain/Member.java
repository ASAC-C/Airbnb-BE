package acac.airbnb.be.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {

    private Long id;

    private String userName;

    private String userLastName;

    private Long birthDay;

    private String email;

    private String password;
}
