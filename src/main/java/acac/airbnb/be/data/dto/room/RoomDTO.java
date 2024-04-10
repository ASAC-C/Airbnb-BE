package acac.airbnb.be.data.dto.room;

import acac.airbnb.be.data.dto.ResultDTO;
import acac.airbnb.be.data.entity.ImageEntity;
import acac.airbnb.be.data.entity.room.RoomEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class RoomDTO extends ResultDTO {
    private Integer roomId;
    private String title;
    private List<String> images;
    private Integer reviewCount;
    private Double rating;

    // 숙박 정보 클래스
    private Lodging lodgingInfo;

    public static RoomDTO of(RoomEntity r) {
        return RoomDTO.builder()
                .roomId(r.getId())
                .title(r.getRoomName())
                .images(r.getMainEntity().getImageEntityList().stream()
                        .map(ImageEntity::getPath)
                        .toList())
                .lodgingInfo(Lodging.of(r))
                .build();
    }
}