package acac.airbnb.be.service.impl;

import acac.airbnb.be.data.dao.ImagePathDAO;
import acac.airbnb.be.data.dto.ImagePathDTO;
import acac.airbnb.be.data.entity.ImagePath;
import acac.airbnb.be.enums.ResType;
import acac.airbnb.be.service.RoomService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private final ImagePathDAO imagePathDAO;

    @Autowired
    public RoomServiceImpl(ImagePathDAO imagePathDAO) {
        this.imagePathDAO = imagePathDAO;
    }

    /**
     * Service <-> DAO : 숙소 이미지 경로 목록 가져오기
     * @param roomId : 숙소 고유 식별자
     */
    @Override
    public ImagePathDTO getImagePath(Integer roomId) {
        ImagePathDTO imagePathDTO = new ImagePathDTO();
        try {
            List<ImagePath> imagePathList = this.imagePathDAO.selectImagePath(roomId);
            imagePathDTO.setRoomId(imagePathList.get(0).getRoomId());
            for (ImagePath dto : imagePathList) {
                imagePathDTO.addPath(dto.getPath());
            }
        // todo. 예외 처리의 타입을 지정을 함수로 빼면 좋을 것 같은데...
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
            imagePathDTO.setResType(ResType.FAIL_ENTITY_NOT_FOUND_EXCEPTION.getNumber());
        }

        return imagePathDTO;
    }
}