package acac.airbnb.be.data.dto.room;

import acac.airbnb.be.data.entity.room.RoomEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RoomAccommodation {

    private List<String> accommodationList = new ArrayList<>();

    public RoomAccommodation(RoomEntity r) {
        r.getRoomAccommodationEntity().forEach(x -> {
            accommodationList.add(x.getSpace() + "/" + x.getFurniture());
        });
    }
}