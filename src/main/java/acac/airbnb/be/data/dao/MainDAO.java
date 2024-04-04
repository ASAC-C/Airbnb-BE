package acac.airbnb.be.data.dao;

import acac.airbnb.be.data.entity.Room;
import acac.airbnb.be.data.dao.repository.MainRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainDAO {
    private final MainRepository roomsRepository;

    /**
     * task : 메인 숙소 정보 요청 (-> DataBase)
     * return : List<Room> Entity
     */
    public List<Room> selectMainRoomsInfo() {
        List<Room> result = roomsRepository.findAll();
        if (CollectionUtils.isEmpty(result)) {
            throw new EntityNotFoundException("Not found in the RoomRepository");
        }

        return result;
    }
}