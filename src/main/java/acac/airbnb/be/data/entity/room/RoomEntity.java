package acac.airbnb.be.data.entity.room;

import acac.airbnb.be.data.entity.MainEntity;
import acac.airbnb.be.data.entity.review.ReviewEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "room")
public class RoomEntity {
    @Id
    private Integer id;

//region @JoinColumn - referencedColumnName 테스트 코드
    /*
     @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    private MainEntity mainEntity;
    */
//endregion

    @NotNull
    @Column(name = "room_name")
    private String roomName;

    @NotNull
    private String description;

    @NotNull
    private String location;

    @NotNull
    @Column(name = "host_name")
    private String hostName;

    @NotNull
    @Column(name = "host_experience")
    private String hostExperience;

    @NotNull
    @Column(name = "accommodation_desc")
    private String accommodationDesc; // 숙소 상세 소개 내용

    // 메인
    @ManyToOne
    private MainEntity mainEntity;

    // 리뷰
    @OneToMany(mappedBy = "roomEntity")
    private List<ReviewEntity> reviewEntityList = new ArrayList<>();

    /**
     * 세부 정보 Entity
     * - RoomServiceEntity       : 대표(?) 서비스
     * - RoomAmenitiesEntity     : 편의 시설
     * - RoomAccommodationEntity : 숙소 시설
     */

    @OneToMany(mappedBy = "roomEntity")
    private List<RoomServiceEntity> roomServiceEntity = new ArrayList<>();

    @OneToMany(mappedBy = "roomEntity")
    private List<RoomAmenitiesEntity> roomAmenitiesEntity = new ArrayList<>();

    @OneToMany(mappedBy = "roomEntity")
    private List<RoomAccommodationEntity> roomAccommodationEntity = new ArrayList<>();
}