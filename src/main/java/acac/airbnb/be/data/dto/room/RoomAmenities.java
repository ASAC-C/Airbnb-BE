package acac.airbnb.be.data.dto.room;

import acac.airbnb.be.data.entity.room.RoomEntity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RoomAmenities {

    private List<String> amenitiesList = new ArrayList<>();

    public RoomAmenities(RoomEntity r) {
        r.getRoomAmenitiesEntity().forEach(x -> {
            amenitiesList.add(x.getTitle() + "/" + x.getImageType());
        });
    }
}
