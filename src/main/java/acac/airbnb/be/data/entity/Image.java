package acac.airbnb.be.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "path")
    private String path;

    // Room 엔티티와 1:N 관계를 가지며 매핑할 이름으로 "room_id" 필드명으로 외래키로 사용한다.
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}