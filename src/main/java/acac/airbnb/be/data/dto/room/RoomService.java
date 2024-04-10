package acac.airbnb.be.data.dto.room;

import acac.airbnb.be.data.entity.room.RoomEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RoomService {

    private List<String> serviceInfoList = new ArrayList<>();

    public RoomService(RoomEntity r) {
        r.getRoomServiceEntity().forEach(x -> {
            serviceInfoList.add(x.getTitle() + "/" + x.getDescription());
        });
    }
}