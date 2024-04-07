package acac.airbnb.be.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDto {
    private  Long id;

    private String useName;

    private Integer reviewNumber;

    private Integer years;

    private String hobby;

    private String country;

    private String firstReview;

    private String secondReview;

}
