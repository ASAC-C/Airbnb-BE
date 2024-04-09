package acac.airbnb.be.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Getter
@NoArgsConstructor //파라미터가 없는 디폴트 생성자를 생성
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자를 생성
public class HomeRequestDto {    
    private Long roomKey;
    private String roomName;
    private String country;
    private String location;
//    private String description;
//    private Long distance;
    private Date possibleCheckIn;
    private Date possibleCheckOut;
//    private Long price;
    private Long maxGuests;
//    private Long bedNum;
//    private Long roomNum;
//    private Long bathNum;
//    private String hostDescription;
//    private Long hostKey;
}