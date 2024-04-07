package acac.airbnb.be.data.dto.main;

import acac.airbnb.be.data.entity.ImageEntity;
import acac.airbnb.be.data.entity.MainEntity;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MainRoomInfo {
    private Integer roomId;
    private String roomName;
    private String country;
    private String location;
    private String possibleCheckIn;
    private String possibleCheckOut;
    private String description;
    private Integer distance;
    private Integer price;
    private Double rating;
    private List<String> images;

    public static MainRoomInfo of(MainEntity e) {
        return MainRoomInfo.builder()
                .roomId(e.getId())
                .roomName(e.getRoomName())
                .country(e.getCountry())
                .location(e.getLocation())
                .possibleCheckIn(e.getPossibleCheckIn().toString())
                .possibleCheckOut(e.getPossibleCheckOut().toString())
                .description(e.getDescription())
                .distance(e.getDistance())
                .price(e.getPrice())
                .rating(0D) // todo. '리뷰' 미구현 상태
                .images(e.getImages().stream()
                        .map(ImageEntity::getPath)
                        .toList())
                .build();
    }
}