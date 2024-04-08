package acac.airbnb.be.data.entity;

import acac.airbnb.be.data.entity.room.RoomEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "main")
public class MainEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 이후에 사용할 수 있는 코드
    /*
    @NotNull
    @Column(name = "room_id", unique = true)
    private Integer roomId;
    */

    @NotNull
    @Column(name = "room_name")
    private String roomName;

    @NotNull
    private String country;

    @NotNull
    private String location;

    @NotNull
    @Column(name = "possible_check_in")
    private LocalDate possibleCheckIn;

    @NotNull
    @Column(name = "possible_check_out")
    private LocalDate possibleCheckOut;

    @NotNull
    private Integer price;

    private String description;
    private Integer distance;
    private Double rating;

    // 현재는 필요 없는 엔티티 같아서 주석 처리
    /*
    @NotNull
    @Column(name = "max_guests")
    private Integer maxGuests;

    @Column(name = "bed_num")
    private Integer bedNum;

    @Column(name = "room_num")
    private Integer roomNum;

    @Column(name = "bath_num")
    private Integer bathNum;

    @NotNull
    @Column(name = "host_description")
    private String hostDescription;

    @NotNull
    @Column(name = "host_key")
    private Integer hostKey;
    */

    @OneToMany(mappedBy = "mainEntity")
    private List<ImageEntity> imageEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "mainEntity")
    private List<RoomEntity> roomEntityList = new ArrayList<>();
}