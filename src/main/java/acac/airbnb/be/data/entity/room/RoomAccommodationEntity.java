package acac.airbnb.be.data.entity.room;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "room_accommodation")
public class RoomAccommodationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String space;

    @NotNull
    private String furniture;

    @ManyToOne
    private RoomEntity roomEntity;
}