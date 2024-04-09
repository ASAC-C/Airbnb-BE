package acac.airbnb.be.data.entity.review;

import acac.airbnb.be.data.entity.room.RoomEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "room_review")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "user_name")
    private String userName;

    @NotNull
    @Column(name = "review_text")
    private String reviewText;

    @NotNull
    private Double cleanliness; // 청결도

    @NotNull
    private Double accuracy; // 정확도

    @NotNull
    @Column(name = "check_in_experience")
    private Double checkInExperience; // 체크인 경험

    @NotNull
    private Double communication; // 의사소통

    @NotNull
    @Column(name = "location_satisfaction")
    private Double locationSatisfaction; // 위치 만족도

    @NotNull
    @Column(name = "value_for_money")
    private Double valueForMoney; // 가격 대비 만족도

    @NotNull
    @ManyToOne
    private RoomEntity roomEntity;
}