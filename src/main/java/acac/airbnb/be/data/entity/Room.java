package acac.airbnb.be.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Integer id;

    @NotNull
    @Column(name = "room_name")
    private String roomName;

    @NotNull
    @Column(name = "country")
    private String country;

    @NotNull
    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;

    @Column(name = "distance")
    private Integer distance;

    @NotNull
    @Column(name = "possible_check_in") // 체크인 날짜
    private LocalDate possibleCheckIn;

    @NotNull
    @Column(name = "possible_check_out") // 체크아웃 날짜
    private LocalDate possibleCheckOut;

    @NotNull
    @Column(name = "price")
    private Integer price;

    @NotNull
    @Column(name = "max_guests")
    private Integer maxGuests;

    @Column(name = "bed_num")
    private Integer bedNum;

    @Column(name = "room_num") // 침실 수
    private Integer roomNum;

    @Column(name = "bath_num") // 욕실 수
    private Integer bathNum;

    @NotNull
    @Column(name = "host_description")
    private String hostDescription;

    @NotNull
    @Column(name = "host_key")
    private Integer hostKey;

    // room -|--------||- image
    @OneToMany(mappedBy = "room")
    private List<Image> images = new ArrayList<>();

    // room -|--------| room_option
//    @OneToOne(mappedBy = "room")
//    private RoomOption roomOption;
}