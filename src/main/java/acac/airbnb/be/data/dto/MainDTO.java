package acac.airbnb.be.data.dto;

import acac.airbnb.be.enums.ResType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MainDTO {
    private List<MainDTO.RoomInfo> rooms;
    private Integer resType = ResType.NONE.getNumber();

    public MainDTO() {
        this.rooms = new ArrayList<>();
    }

    @Getter
    @Setter
    @Builder
    public static class RoomInfo {
        private Integer roomId;
        private String country;
        private String location;
        private String description;
        private Integer distance;
        private String possibleCheckIn;
        private String possibleCheckOut;
        private Integer price;
        private Double rating;

        // @Setter 애노테이션은 컬렉션 타입에 대해서는 동작하지 않는다.
        @Builder.Default
        private List<String> images = new ArrayList<>();

        public void addImagePath(String path)
        {
            if(!images.contains(path))
                images.add(path);
        }
    }

    public void addRoomInfo(MainDTO.RoomInfo roomInfo) {
        if(rooms.contains(roomInfo))
            return;

        rooms.add(roomInfo);
    }
}