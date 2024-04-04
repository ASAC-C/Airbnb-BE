package acac.airbnb.be.service.impl;

import acac.airbnb.be.data.dao.RoomDAO;
import acac.airbnb.be.data.dao.MainDAO;
import acac.airbnb.be.data.dto.RoomDTO;
import acac.airbnb.be.data.dto.MainDTO;
import acac.airbnb.be.data.dto.RoomInfoDto;
import acac.airbnb.be.data.entity.Room;
import acac.airbnb.be.enums.ResType;
import acac.airbnb.be.service.RoomService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private final MainDAO roomsDAO;
    private final RoomDAO imagePathDAO;

    @Autowired
    public RoomServiceImpl(MainDAO roomsDAO, RoomDAO imagePathDAO) {
        this.roomsDAO = roomsDAO;
        this.imagePathDAO = imagePathDAO;
    }

    // ============================================================================================ //
    // Architecture : Controller <- (DTO) -> Service <- (DTO or Data) -> DAO

    /**
     * task : 메인 숙소 정보 요청 (-> DAO)
     * return : RoomsResponseDTO
     */
    @Override
    public MainDTO getMainRoomsInfo() {
        try {
            List<Room> roomList = roomsDAO.selectMainRoomsInfo();
            List<RoomInfoDto> dto = roomList.stream()
                    .map(RoomInfoDto::of)
                    .toList();
            return MainDTO.success(dto);
        } catch (EntityNotFoundException e) {
            // throw new RuntimeException
            return MainDTO.failed(ResType.FAIL_ENTITY_NOT_FOUND_EXCEPTION);
        }
    }

    /**
     * task   : 숙소 상세 정보 요청 (-> DAO)
     * return : ImageDTO
     * param  : roomId(숙소 고유 식별자)
     */
    @Override
    public RoomDTO getRoomInfo(Integer roomId) {
        RoomDTO roomDTO = new RoomDTO();
        try {

        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
        }

//        try {
//            List<Image> imagePathList = this.imagePathDAO.selectImagePath(roomKey);
//            imagePathDTO.setRoomKey(imagePathList.get(0).getRoomKey());
//            for (Image dto : imagePathList) {
//                imagePathDTO.addPath(dto.getPath());
//            }
//        } catch (EntityNotFoundException e) {
//            System.err.println(e.getMessage());
//            imagePathDTO.setResType(ResType.FAIL_ENTITY_NOT_FOUND_EXCEPTION.getNumber());
//        }

        return roomDTO;
    }
}