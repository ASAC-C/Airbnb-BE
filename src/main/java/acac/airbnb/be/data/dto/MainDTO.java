package acac.airbnb.be.data.dto;

import acac.airbnb.be.enums.ResType;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MainDTO {
    private List<RoomInfoDto> rooms;
    private ResType resType;

    public static MainDTO success(List<RoomInfoDto> param) {
        return new MainDTO(param, ResType.SUCCESS);
    }

    public static MainDTO failed(ResType type) {
        return new MainDTO(new ArrayList<>(), type);
    }
}