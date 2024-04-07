package acac.airbnb.be.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "main")
public class MainEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "room_id")
    private Integer roomId;

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
    private List<ImageEntity> images = new ArrayList<>();
}