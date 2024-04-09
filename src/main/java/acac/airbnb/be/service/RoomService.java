package acac.airbnb.be.service;

import acac.airbnb.be.data.dto.ResultDTO;
import acac.airbnb.be.data.dto.main.MainDTO;
import acac.airbnb.be.data.dto.main.MainRoomInfo;
import acac.airbnb.be.data.dto.review.ReviewDTO;
import acac.airbnb.be.data.dto.room.RoomDTO;
import acac.airbnb.be.data.entity.MainEntity;
import acac.airbnb.be.data.entity.room.RoomEntity;
import acac.airbnb.be.data.repository.MainRepository;
import acac.airbnb.be.data.repository.ReviewRepository;
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
    private final ReviewRepository reviewRepository;

    // ====================================================================================== //
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
                throw new EmptyResultDataAccessException(0);
            }
            List<MainRoomInfo> mainRoomInfoList = mainEntityList
                    .stream()
                    .map(MainRoomInfo::of)
                    .toList();

//region 평점 계산을 직접 하는 코드
            /*
            int index = 0;
            int reviewCount = 0;
            double avgRating = 0D;

            for (MainEntity m : mainEntityList) {
                List<RoomEntity> roomEntityList = m.getRoomEntityList();
                if (CollectionUtils.isEmpty(roomEntityList))
                    continue;

                for (RoomEntity r : roomEntityList) {
                    List<ReviewEntity> reviewEntityList = r.getReviewEntityList();
                    if (CollectionUtils.isEmpty(reviewEntityList))
                        break;

                    for (ReviewEntity review : reviewEntityList) {
                        avgRating += review.getCleanliness() +
                                review.getAccuracy() +
                                review.getCheckInExperience() +
                                review.getCommunication() +
                                review.getLocationSatisfaction() +
                                review.getValueForMoney();

                        reviewCount++;
                    }
                }
                mainRoomInfoList.get(index).setRating(avgRating / reviewCount);
                reviewCount = 0;
                index++;
            }
            */
//endregion

            // 평점
            for (MainRoomInfo m : mainRoomInfoList) {
                Double rating = reviewRepository.getAverageRating(m.getRoomId());
                if (rating == null) {
                    rating = 0D;
                }
                m.setRating(Math.round(rating * 100) / 100.0);
            }
            MainDTO mainDTO = MainDTO.of(mainRoomInfoList);
            return mainDTO.success("데이터 조회에 성공했습니다.");
        } catch (EmptyResultDataAccessException e) {
            return MainDTO.failed(
                    ResType.FAIL_EMPTY_RESULT_DATA_ACCESS_EXCEPTION,
                    "데이터 조회에 실패했습니다."
            );
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * task   : 숙소 상세 정보 요청 (-> Repository)
     * param  : 숙소 고유 아이디
     * return : ResultDTO
     */
    public ResultDTO getRoomInfo(int roomId) {
        try {
            RoomEntity roomEntity = roomRepository.findById(roomId).orElseThrow(NoSuchElementException::new);

            // 평점
            Double rating = reviewRepository.getAverageRating(roomId);
            if (rating == null)
                rating = 0D;

            // 리뷰 갯수
            Integer reviewCount = reviewRepository.getReviewCount(roomId);
            if (reviewCount == null)
                reviewCount = 0;

            RoomDTO roomDTO = RoomDTO.of(roomEntity);
            roomDTO.setRating(rating);
            roomDTO.setReviewCount(reviewCount);
            return roomDTO.success("데이터 조회에 성공했습니다.");
        } catch (NoSuchElementException e) {
            return RoomDTO.failed(
                    ResType.FAIL_NO_SUCH_ELEMENT_EXCEPTION,
                    "데이터 조회에 실패했습니다. id : " + roomId);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * task : 숙소 리뷰 정보 요청 (-> Repository)
     * param
     * - roomId : 숙소 고유 아이디
     * - filter : 검색 필터
     * return : ResultDTO
     */
    public ResultDTO getRoomReviewFilter(int roomId, String filter) {
        try {
            RoomEntity roomEntity = roomRepository.findById(roomId).orElseThrow(() -> {
                throw new NoSuchElementException();
            });

            // 평점
            Double rating = reviewRepository.getAverageRating(roomId);
            if (rating == null) {
                rating = 0D;
            }

            ReviewDTO reviewDTO = new ReviewDTO(roomEntity.getReviewEntityList());
            reviewDTO.getReviewAuthorList().removeIf(author -> !author.getContent().contains(filter));
            reviewDTO.setTotalAvg(rating);
            return reviewDTO.success("데이터 조회에 성공했습니다.");
        } catch (NoSuchElementException e) {
            return RoomDTO.failed(
                    ResType.FAIL_NO_SUCH_ELEMENT_EXCEPTION,
                    "데이터 조회에 실패했습니다. id : " + roomId);
        } catch (Exception e) {
            throw e;
        }
    }
}