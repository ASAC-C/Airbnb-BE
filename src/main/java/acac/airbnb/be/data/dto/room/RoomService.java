package acac.airbnb.be.data.dto.room;

import acac.airbnb.be.data.entity.room.RoomEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RoomService {
    private String title;
    private String description;

    public RoomService(RoomEntity r) {
        System.out.println(r.getRoomServiceEntity());
        r.getRoomServiceEntity().forEach(x -> {
            title = x.getTitle();
            description = x.getDescription();
        });
    }
}