package acac.airbnb.be.data.dto.room;

import acac.airbnb.be.data.entity.room.RoomEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Amenities {
    private String title;
    private Integer imageType;

    public Amenities(RoomEntity r) {
        r.getRoomAmenitiesEntity().forEach(x -> {
            title = x.getTitle();
            imageType = x.getImageType();
        });
    }
}
