package acac.airbnb.be.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Setter
@Getter
@Table(name = "profile")
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "review_number")
    private Integer reviewNumber;

    @Column(name = "years")
    private Integer years;

    @Column(name = "hobby")
    private String hobby;

    @Column(name = "country")
    private String country;

    @Column(name = "first_review")
    private String firstReview;

    @Column(name = "second_review")
    private String secondReview;

}
