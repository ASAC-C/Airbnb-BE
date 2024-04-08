package acac.airbnb.be.data.repository;

import acac.airbnb.be.data.entity.room.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {
//    Optional<RoomEntity> findById(Integer roomId);
}