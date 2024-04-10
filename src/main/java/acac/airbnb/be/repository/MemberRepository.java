package acac.airbnb.be.repository;

import acac.airbnb.be.domain.MemberDto;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    MemberDto save(MemberDto member); // member 데이터 저장
    Optional<MemberDto> findById(Long id);
    Optional<MemberDto> findByEmail(String email);
    List<MemberDto> findAll(); // 모든 member 조회
}
