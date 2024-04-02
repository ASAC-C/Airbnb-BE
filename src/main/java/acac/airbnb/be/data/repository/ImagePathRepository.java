package acac.airbnb.be.data.repository;

import acac.airbnb.be.data.entity.ImagePath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagePathRepository extends JpaRepository<ImagePath, Long> { // <@Entity, @Id>
    // =================================
    /* Spring Data JPA에서 자동으로 구현 */
    // =================================

    List<ImagePath> findByRoomId(Integer roomId);
}