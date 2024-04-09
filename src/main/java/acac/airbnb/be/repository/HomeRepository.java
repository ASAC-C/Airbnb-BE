package acac.airbnb.be.repository;

import acac.airbnb.be.model.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

//@Repository
public interface HomeRepository extends JpaRepository<Rooms, Long> {//pk key 값

    List<Rooms> findAllByLocation(String location, Date possible_check_In, Date possibleCheckOut, Long maxGuests);

}