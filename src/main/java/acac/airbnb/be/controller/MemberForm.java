package acac.airbnb.be.controller;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberForm {

    private Long id;
    private String user_name;
    private String user_last_name;
    private Long birth_day;
    private String email;
    private String password;

}
