package acac.airbnb.be.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Rooms {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id //pk로지정
    private Long roomKey;

    @Column(nullable = false) //필수값 설정
    private String roomName;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String location;

    @Column
    private String description;

    @Column
    private Long distance;

    @Column(nullable = false)
    private Date possibleCheckIn;

    @Column(nullable = false)
    private Date possibleCheckOut;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private Long maxGuests;

    @Column
    private Long bedNum;

    @Column
    private Long roomNum;

    @Column
    private Long bathNum;

    @Column(nullable = false)
    private String hostDescription;

    @Column(nullable = false)
    private Long hostKey;

}