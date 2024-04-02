package acac.airbnb.be.data.dao;

import acac.airbnb.be.data.entity.ImagePath;
import acac.airbnb.be.data.repository.ImagePathRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * '조회'만 있는 기능으로 클래스로만 구현
 */
@Component
public class ImagePathDAO {

    private final ImagePathRepository imagePathRepository;

    @Autowired
    public ImagePathDAO(ImagePathRepository imagePathRepository) {
        this.imagePathRepository = imagePathRepository;
    }

    /**
     * DAO -> Repository : 데이터베이스에 접근하여 roomdId 값과 일치하는 값 가져오기
     * @param roomId : 숙소 고유 식별자
     */
    public List<ImagePath> selectImagePath(Integer roomId) {
        List<ImagePath> result = this.imagePathRepository.findByRoomId(roomId);
        if (result.isEmpty()) {
            throw new EntityNotFoundException("Entity with roomId " + roomId + " not found");
        }

        return result;
    }
}