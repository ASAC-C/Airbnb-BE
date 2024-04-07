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
    @NotNull
    @Size(min = 0, max = 10)
    @JsonProperty(value = "user_name", defaultValue = "luda", required = true)
    private String username;
    @JsonProperty(value = "user_last_name")
    private String userLastName;
    @JsonProperty(value = "birth_day")
    private Long birthday;
    private String email;
    private String password;

}
