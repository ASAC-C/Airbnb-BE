package acac.airbnb.be.repository;

import acac.airbnb.be.domain.MemberDto;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    MemberDto save(MemberDto member);
    Optional<MemberDto> findById(Long id);
    Optional<MemberDto> findByEmail(String email);
    List<MemberDto> findAll();
}
