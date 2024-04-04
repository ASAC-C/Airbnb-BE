package acac.airbnb.be.data.dto;

import acac.airbnb.be.data.entity.Image;
import acac.airbnb.be.data.entity.Room;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class RoomInfoDto {
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

    public static RoomInfoDto of(Room entity) {
        return RoomInfoDto.builder()
                .roomId(entity.getId())
                .country(entity.getCountry())
                .location(entity.getLocation())
                .description(entity.getDescription())
                .distance(entity.getDistance())
                .possibleCheckIn(entity.getPossibleCheckIn().toString())
                .possibleCheckOut(entity.getPossibleCheckOut().toString())
                .price(entity.getPrice())
                .rating(0D) // todo. '리뷰' 관련 테이블에서 가져와야하는데..미구현 상태
                .images(entity.getImages().stream()
                        .map(Image::getPath)
                        .toList())
                .build();
    }
}