package acac.airbnb.be.data.dto;

import acac.airbnb.be.enums.ResType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RoomDTO {
    private Integer roomKey;
    private List<String> pathList; // @Setter 애노테이션은 컬렉션 타입에 대해서는 동작하지 않는다.

    // 기본 값으로 SUCCESS 타입으로 설정해주고 Exception이 발생하면 Exception 타입을 설정한다.
    private Integer resType = ResType.SUCCESS.getNumber();

    public RoomDTO() {
        this.pathList = new ArrayList<String>();
    }

    /**
     * 이미지 경로 추가, @Setter 애노테이션은 컬렉션 타입에 대해서는 동작하지 않는다.
     * @param path : 이미지 경로
     */
    public void addPath(String path) {
        pathList.add(path);
    }
}