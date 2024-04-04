package acac.airbnb.be.data.dao.repository;

import acac.airbnb.be.data.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainRepository extends JpaRepository<Room, Long> {
    /* Spring Data JPA에서 자동으로 구현 */

    @Query("SELECT r FROM Room r LEFT JOIN FETCH r.images")
    List<Room> findAllWithImages();
}