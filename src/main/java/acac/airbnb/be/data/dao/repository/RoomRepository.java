package acac.airbnb.be.data.dao.repository;

import acac.airbnb.be.data.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Image, Long> { // <@Entity, @Id>

//    List<Image> findByRoomKey(Integer roomKey);
}