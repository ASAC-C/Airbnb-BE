package acac.airbnb.be.data.dto.main;

import acac.airbnb.be.data.entity.ImageEntity;
import acac.airbnb.be.data.entity.MainEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class MainRoomInfo {
    private Integer roomId;
    private String roomName;
    private String country;
    private String location;
    private String description;
    private String possibleCheckIn;
    private String possibleCheckOut;
    private Integer distance;
    private Integer price;
    private Double rating;
    private List<String> images;

    public static MainRoomInfo of(MainEntity e) {
        return MainRoomInfo.builder()
                .roomId(e.getRoomId())
                .roomName(e.getRoomName())
                .country(e.getCountry())
                .location(e.getLocation())
                .possibleCheckIn(e.getPossibleCheckIn().toString())
                .possibleCheckOut(e.getPossibleCheckOut().toString())
                .description(e.getDescription())
                .distance(e.getDistance())
                .price(e.getPrice())
                .images(e.getImageEntityList().stream()
                        .map(ImageEntity::getPath)
                        .toList())
                .build();
    }
}