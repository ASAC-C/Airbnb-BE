package acac.airbnb.be.data.dao;

import acac.airbnb.be.data.entity.Image;
import acac.airbnb.be.data.dao.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * '조회'만 있는 기능으로 클래스로만 구현
 */
@Component
public class RoomDAO {

    private final RoomRepository imagePathRepository;

    @Autowired
    public RoomDAO(RoomRepository imagePathRepository) {
        this.imagePathRepository = imagePathRepository;
    }

    /**
     * DAO -> Repository : 데이터베이스에 접근하여 roomdId 값과 일치하는 값 가져오기r
     */
    public List<Image> selectImagePath(Integer roomKey) {
//        List<Image> result = this.imagePathRepository.findByRoomKey(roomKey);
//        if (result.isEmpty()) {
//            throw new EntityNotFoundException("Entity with roomKey " + roomKey + " not found");
//        }
//
//        return result;
        return null;
    }
}