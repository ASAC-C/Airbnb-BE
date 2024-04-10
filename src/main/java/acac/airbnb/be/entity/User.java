package acac.airbnb.be.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity //JPA Entity 클래스 임을 명시
@Table(name = "member") //데이터 베이스 테이블 이름 지정
public class User {
    @Id // 기본 키를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 생성 지정
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_last_name")
    private String userLastName;

    @Column(name = "birth_day")
    private Long birthDay;

    @Column(name = "email", unique = true) // unique는 해당 필드의 값이 고유함을 나타냄, 칼럼에 중복되어 저장되지 않게 함
    private String email;

    @Column(name = "password", unique = true)
    private String password;
}
