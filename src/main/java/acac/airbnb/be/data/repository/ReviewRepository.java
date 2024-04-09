package acac.airbnb.be.data.repository;

import acac.airbnb.be.data.entity.review.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {

    // 리뷰 갯수
    @Query("SELECT COUNT(r) FROM ReviewEntity r WHERE r.roomEntity.id = :roomId")
    Integer getReviewCount(@Param("roomId") Integer roomId);

    // 평점
    @Query("SELECT SUM(r.cleanliness + r.accuracy + r.checkInExperience + r.communication + r.locationSatisfaction + r.valueForMoney) / (COUNT(r) * 6) " +
            "FROM ReviewEntity r WHERE r.roomEntity.id = :roomId")
    Double getAverageRating(@Param("roomId") Integer roomId);
}