package acac.airbnb.be.data.dto.review;

import acac.airbnb.be.data.entity.review.ReviewEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ReviewAuthor {
    private String name;
    private String content;
    private Double cleanliness;
    private Double accuracy;
    private Double checkInExperience;
    private Double communication;
    private Double locationSatisfaction;
    private Double valueForMoney;

    public static ReviewAuthor of(ReviewEntity e) {
        return ReviewAuthor.builder()
                .name(e.getUserName())
                .content(e.getReviewText())
                .cleanliness(e.getCleanliness())
                .accuracy(e.getAccuracy())
                .checkInExperience(e.getCheckInExperience())
                .communication(e.getCommunication())
                .locationSatisfaction(e.getLocationSatisfaction())
                .valueForMoney(e.getValueForMoney())
                .build();
    }
}