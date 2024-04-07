package acac.airbnb.be.data.dto.room;

import acac.airbnb.be.data.entity.room.RoomEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Lodging {
    private String location;
    private String description;
    private Integer reviewCount;
    private String hostName;
    private String hostExperience;
    private String accommodationDescription; // 숙소 설명

    // 서비스
    private RoomService service;

    // 숙박 장소
    private RoomAccommodation accommodation;

    // 편의 시설
    private Amenities amenities;

    public static Lodging of(RoomEntity r) {
        return Lodging.builder()
                .location(r.getLocation())
                .description(r.getDescription())
                .reviewCount(r.getReviewCount())
                .hostName(r.getHostName())
                .hostExperience(r.getHostExperience())
                .accommodationDescription(r.getAccommodationDesc())
                .service(new RoomService(r))
                .accommodation(new RoomAccommodation(r))
                .amenities(new Amenities(r))
                .build();
    }
}