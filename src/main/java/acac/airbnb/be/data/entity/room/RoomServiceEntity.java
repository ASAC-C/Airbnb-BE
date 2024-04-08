package acac.airbnb.be.data.entity.room;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "room_service")
public class RoomServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @ManyToOne
    private RoomEntity roomEntity;
}
