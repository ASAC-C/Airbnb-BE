package acac.airbnb.be.service;

import acac.airbnb.be.data.dto.ResultDTO;
import acac.airbnb.be.data.dto.main.MainDTO;
import acac.airbnb.be.data.dto.main.MainRoomInfo;
import acac.airbnb.be.data.dto.room.RoomDTO;
import acac.airbnb.be.data.entity.MainEntity;
import acac.airbnb.be.data.entity.room.RoomEntity;
import acac.airbnb.be.data.repository.MainRepository;
import acac.airbnb.be.data.repository.RoomRepository;
import acac.airbnb.be.enums.ResType;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final MainRepository mainRepository;
    private final RoomRepository roomRepository;

    // ============================================================================== //
    // Architecture : Controller <- (DTO) -> Service <- (DTO or Data) -> DAO
    // (변경) : Controller <- (DTO) -> Service <- (DTO or Data) -> Repository

    /**
     * task : 메인 숙소 정보 요청 (-> Repository)
     * return : ResultDTO
     */
    public ResultDTO getMainRoomsInfo() {
        try {
            List<MainEntity> mainEntityList = mainRepository.findAll();
            if (CollectionUtils.isEmpty(mainEntityList)) {
                // 서비스 및 DB 접근 레이어에서 발생한 예외처리는 해당 클래스 및 메서드 내부에서 처리
                throw new EmptyResultDataAccessException(0);
            }
            List<MainRoomInfo> mainRoomInfoList = mainEntityList
                    .stream()
                    .map(MainRoomInfo::of)
                    .toList();
            MainDTO mainDTO = MainDTO.of(mainRoomInfoList);
            return mainDTO.success("Data found successfully.");
        } catch (EmptyResultDataAccessException e) {
            return MainDTO.failed(
                    ResType.FAIL_NO_SUCH_ELEMENT_EXCEPTION,
                    "Data retrieval failed."
            );
        } catch (RuntimeException e) {
            throw e;
        }
    }

    /**
     * task   : 숙소 상세 정보 요청 (-> Repository)
     * param  : 숙소 고유 아이디
     * return : ResultDTO
     */
    public ResultDTO getRoomInfo(Integer roomId) {
        try {
            RoomEntity roomEntity = roomRepository.findById(roomId).orElseThrow(() -> {
                throw new NoSuchElementException();
            });
            RoomDTO roomDTO = RoomDTO.of(roomEntity);
            return roomDTO.success("Lodging information retrieved successfully.");
        } catch (NoSuchElementException e) {
            return RoomDTO.failed(
                    ResType.FAIL_NO_SUCH_ELEMENT_EXCEPTION,
                    "Lodging information retrieval failed.");
        } catch (Exception e) {
            throw e;
        }
    }
}