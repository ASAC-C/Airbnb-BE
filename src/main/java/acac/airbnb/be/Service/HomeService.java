package acac.airbnb.be.Service;

import acac.airbnb.be.dto.HomeResponseDto;
import acac.airbnb.be.repository.HomeRepository;
import acac.airbnb.be.model.Rooms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HomeService {
    private final HomeRepository homeRepository; //HomeRepository 의존성 주입을 위한 멤버 변수

    //생성자를 통한 의존성 주입
    @Autowired
    public HomeService(HomeRepository homeRepository) {
        this.homeRepository = homeRepository; //HomeRepository 의존성 주입
    }

    //숙소 검색하기
    public List<HomeResponseDto> searchList(String location, Date possibleCheckIn, Date possibleCheckOut, Long maxGuests) {

        //검색 결과 값 DB조회
        List<Rooms> rooms = homeRepository.findAllByLocation(location, possibleCheckIn, possibleCheckOut, maxGuests);
        //검색된 숙소 정보를 담을 리스트 생성
        List<HomeResponseDto> homeResponseDtos = new ArrayList<>();

        //검색된 숙소 목록을 반복하여 각 숙서 정보를 DTO로 변환
        for (Rooms room : rooms) {
            HomeResponseDto homeResponseDto = new HomeResponseDto(
                room.getRoomKey(),
                room.getRoomName(),
                room.getCountry(),
                room.getLocation(),
                room.getDescription(),
                room.getDistance(),
                room.getPossibleCheckIn(),
                room.getPossibleCheckOut(),
                room.getPrice(),
                room.getMaxGuests(),
                room.getBedNum(),
                room.getRoomNum(),
                room.getBathNum(),
                room.getHostDescription(),
                room.getHostKey()
            );
            homeResponseDtos.add(homeResponseDto);
        }

        return homeResponseDtos;
    }

}
