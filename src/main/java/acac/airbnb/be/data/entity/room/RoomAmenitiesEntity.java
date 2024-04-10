package acac.airbnb.be.data.entity.room;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "room_amenities")
public class RoomAmenitiesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String title;

    @NotNull
    private Integer imageType;

    @ManyToOne
    private RoomEntity roomEntity;
}