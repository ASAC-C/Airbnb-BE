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
@Getter
@Setter
@Table(name = "main")
public class MainEntity implements Serializable {
    @Id
    @Column(name = "room_id")
    private Integer roomId;

//region @JoinColumn - referencedColumnName 테스트 코드
    /*
    @NotNull
    @Column(name = "room_id", unique = true)
    private Integer roomId;
    */
//endregion

    @NotNull
    @Column(name = "room_name")
    private String roomName;

    @Column(name = "description")
    private String description;

    @NotNull
    private String country;

    @NotNull
    private String location;

    @Column(name = "distance")
    private Integer distance;

    @NotNull
    private Integer price;

    @NotNull
    @Column(name = "possible_check_in")
    private LocalDate possibleCheckIn;

    @NotNull
    @Column(name = "possible_check_out")
    private LocalDate possibleCheckOut;

    // 숙소
    @OneToMany(mappedBy = "mainEntity")
    private List<RoomEntity> roomEntityList = new ArrayList<>();

    // 이미지
    @OneToMany(mappedBy = "mainEntity")
    private List<ImageEntity> imageEntityList = new ArrayList<>();
}