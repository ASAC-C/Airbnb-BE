package acac.airbnb.be.controller;

import acac.airbnb.be.data.dto.MainDTO;
import acac.airbnb.be.service.RoomService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    /**
     * task   : 메인 숙소 정보 요청 (-> Service)
     * return : json
     */
    @GetMapping("/main")
    @ResponseBody
    public String mainRoomInfo() {
        MainDTO mainDTO = this.roomService.getMainRoomsInfo();
        return DTOConverToJson(mainDTO);
    }

    /**
     * task   : 숙소 상세 정보 요청 (-> Service)
     * param  : roomId
     * return : json
     */
    @GetMapping("")
    @ResponseBody
    public String roomImageList(@RequestParam(name = "roomId") Integer roomId) {
//        ImagePathDTO imagePathDTO = this.roomService.getImagePath(room_id);
//        return DTOConverToJson(imagePathDTO);
        return "123";
    }










    @GetMapping("/")

    /**
     * DTO 클래스를 json 타입으로 변환
     * @param object : DTO 클래스
     * @return : json
     */ private String DTOConverToJson(Object object) {
        String json = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        return json;
    }
}