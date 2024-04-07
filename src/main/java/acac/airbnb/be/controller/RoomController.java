package acac.airbnb.be.controller;

import acac.airbnb.be.data.dto.ResultDTO;
import acac.airbnb.be.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    /**
     * task   : 메인 숙소 정보 요청 (-> Service)
     * return : ResultDTO
     */
    @GetMapping("/main")
    public ResultDTO mainRoomInfo() {
        return roomService.getMainRoomsInfo();
    }

    /**
     * task   : 숙소 상세 정보 요청 (-> Service)
     * param  : 숙소 고유 아이디
     * return : ResultDTO
     */
    @GetMapping("")
    public ResultDTO roomImageList(@RequestParam("roomId") Integer roomId) {
        return roomService.getRoomInfo(roomId);
    }
}