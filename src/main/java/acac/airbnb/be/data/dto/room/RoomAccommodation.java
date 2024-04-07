package acac.airbnb.be.data.dto.room;

import acac.airbnb.be.data.entity.room.RoomEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RoomAccommodation {
    private String space;
    private String furniture; // 가구

    public RoomAccommodation(RoomEntity r) {
        r.getRoomAccommodationEntity().forEach(x -> {
            space = x.getSpace();
            furniture = x.getFurniture();
        });
    }
}