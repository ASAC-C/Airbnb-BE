package acac.airbnb.be.data.dto.review;

import acac.airbnb.be.data.dto.ResultDTO;
import acac.airbnb.be.data.entity.review.ReviewEntity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewDTO extends ResultDTO {

    private Double totalAvg;
    private List<ReviewAuthor> reviewAuthorList = new ArrayList<>();

    public ReviewDTO(List<ReviewEntity> reviewEntityList) {
        for (ReviewEntity e : reviewEntityList) {
            reviewAuthorList.add(ReviewAuthor.of(e));
        }
    }
}