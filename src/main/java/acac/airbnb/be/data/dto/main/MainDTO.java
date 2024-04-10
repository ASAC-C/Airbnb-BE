package acac.airbnb.be.data.dto.main;

import acac.airbnb.be.data.dto.ResultDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MainDTO extends ResultDTO {

    private List<MainRoomInfo> mainRoomInfoList;

    public static MainDTO of(List<MainRoomInfo> mainRoomInfoList) {
        return new MainDTO(mainRoomInfoList);
    }
}