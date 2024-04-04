package acac.airbnb.be.service.impl;

import acac.airbnb.be.data.dao.RoomDAO;
import acac.airbnb.be.data.dao.MainDAO;
import acac.airbnb.be.data.dto.RoomDTO;
import acac.airbnb.be.data.dto.MainDTO;
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
        MainDTO mainDTO = new MainDTO();
        try {
            List<Room> roomList = this.roomsDAO.selectMainRoomsInfo();

            // Entity conver to DTO
            for (Room e : roomList) {
                MainDTO.RoomInfo roomInfo = MainDTO.RoomInfo.builder()
                        .roomId(e.getId())
                        .country(e.getCountry())
                        .location(e.getLocation())
                        .description(e.getDescription())
                        .distance(e.getDistance())
                        .possibleCheckIn(e.getPossibleCheckIn().toString())
                        .possibleCheckOut(e.getPossibleCheckOut().toString())
                        .price(e.getPrice())
                        .rating(0D) // todo. '리뷰' 관련 테이블에서 가져와야하는데..미구현 상태
                        .build();

                e.getImages().forEach(img -> {
                    roomInfo.addImagePath(img.getPath());
                });

                // add
                mainDTO.addRoomInfo(roomInfo);
                mainDTO.setResType(ResType.SUCCESS.getNumber());
            }
        // todo. 예외 처리의 타입을 지정을 함수로 뺄 수 있나 ?
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
            mainDTO.setResType(ResType.FAIL_ENTITY_NOT_FOUND_EXCEPTION.getNumber());
        }

        return mainDTO;
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