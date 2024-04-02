package acac.airbnb.be.controller;

import acac.airbnb.be.data.dto.ImagePathDTO;
import acac.airbnb.be.service.RoomService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    /**
     * 모든 숙소 정보
     * @param id : 숙소 고유 식별자
     */
    @GetMapping("/{id}")
    @ResponseBody
    public void info(@PathVariable("id") String id) {
        try {
            // todo. id로 데이터베이스 조회
            return;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    /**
     * Client <-> Controller : 숙소 이미지 경로 목록 가져오기
     * @param roomKey : 숙소 고유 식별자
     */
    @GetMapping("/image-list")
    @ResponseBody
    public String roomImageList(@RequestParam("roomKey") Integer roomKey) {
        ImagePathDTO imagePathDTO = this.roomService.getImagePath(roomKey);
        return DTOConverToJson(imagePathDTO);
    }

    @GetMapping("/")

    /**
     * DTO 클래스를 json 타입으로 변환
     * @param object : DTO 클래스
     * @return : json
     */
    private String DTOConverToJson(Object object) {
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