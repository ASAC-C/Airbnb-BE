package acac.airbnb.be.data.dto.room;

import acac.airbnb.be.data.entity.room.RoomEntity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RoomService {

    private List<String> serviceInfoList = new ArrayList<>();

    public RoomService(RoomEntity r) {
        r.getRoomServiceEntity().forEach(x -> {
            serviceInfoList.add(x.getTitle() + "/" + x.getDescription());
        });
    }
}