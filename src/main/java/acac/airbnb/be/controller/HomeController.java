package acac.airbnb.be.controller;

import acac.airbnb.be.Service.HomeService;
import acac.airbnb.be.dto.HomeResponseDto;
import acac.airbnb.be.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class HomeController {

    private final HomeService homeService;


    @Autowired
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    /**
     * Home 검색
     */
//    @GetMapping("/")
//    public String home(){
//        return "home";
//    }
    //검색
    @GetMapping("/search")
    public ResponseDto searchList(@RequestParam("location") String location,
                                  @RequestParam("possible_check_in") Date possibleCheckIn,
                                  @RequestParam("possible_check_out") Date possibleCheckOut,
                                  @RequestParam("max_guests") Long maxGuests) {

        List<HomeResponseDto> roomList = homeService.searchList(location,possibleCheckIn, possibleCheckOut, maxGuests);

        System.out.print(roomList);
        if(roomList.isEmpty()){
            return new ResponseDto("failed", "검색 된 결과가 없습니다.", null);
        }else
            return new ResponseDto("success", "검색 완료", roomList);
    }

}