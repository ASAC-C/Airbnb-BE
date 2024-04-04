package acac.airbnb.be.controller;

import acac.airbnb.be.data.dto.MainDTO;
import acac.airbnb.be.service.RoomService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    /**
     * task   : 숙소 상세 정보 요청 (-> Service)
     * param  : roomId
     * return : json
     */
    @GetMapping("")
    public String roomImageList(@RequestParam(name = "roomId") Integer roomId) {
//        ImagePathDTO imagePathDTO = this.roomService.getImagePath(room_id);
//        return DTOConverToJson(imagePathDTO);
        return "123";
    }

    /**
     * task   : 메인 숙소 정보 요청 (-> Service)
     * return : json
     */
    @GetMapping("/main")
    public MainDTO mainRoomInfo() {
        return roomService.getMainRoomsInfo();
    }
}