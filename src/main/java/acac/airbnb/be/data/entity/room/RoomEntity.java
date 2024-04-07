package acac.airbnb.be.data.entity.room;

import acac.airbnb.be.data.entity.MainEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "room")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String title;

    @NotNull
    private String location;

    @NotNull
    private String description;

    @NotNull
    @Column(name = "review_count")
    private Integer reviewCount;

    @NotNull
    @Column(name = "host_name")
    private String hostName;

    @NotNull
    @Column(name = "host_experience")
    private String hostExperience;

    @NotNull
    @Column(name = "accom_desc")
    private String accommodationDesc;

    @NotNull
    @ManyToOne
    private MainEntity mainEntity;

    // OneToMany (@JoinColumn을 사용하지 않는 경우)
    // 외래 키는 기본적으로 다측 엔티티의 테이블에 추가되며, 부모 엔티티의 기본 키와 매핑
    // 외래 키를 관리하는 쪽이 주인이며, 주인을 나타내는 mappedBy 속성은 주인이 아닌 쪽에 설정한다.

    @OneToMany(mappedBy = "roomEntity")
    private List<RoomServiceEntity> roomServiceEntity = new ArrayList<>();

    @OneToMany(mappedBy = "roomEntity")
    private List<RoomAmenitiesEntity> roomAmenitiesEntity = new ArrayList<>();

    @OneToMany(mappedBy = "roomEntity")
    private List<RoomAccommodationEntity> roomAccommodationEntity = new ArrayList<>();
}