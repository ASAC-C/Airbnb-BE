package acac.airbnb.be.data.dao;

import acac.airbnb.be.data.entity.Room;
import acac.airbnb.be.data.dao.repository.MainRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MainDAO {

    private final MainRepository roomsRepository;

    public MainDAO(MainRepository roomsRepository) {
        this.roomsRepository = roomsRepository;
    }

    /**
     * task : 메인 숙소 정보 요청 (-> DataBase)
     * return : List<Room> Entity
     */
    public List<Room> selectMainRoomsInfo() {
        List<Room> result = this.roomsRepository.findAll();
        if (result.isEmpty()) {
            throw new EntityNotFoundException("Not found in the database.");
        }

        return result;
    }
}