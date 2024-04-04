package acac.airbnb.be.repository;

import acac.airbnb.be.domain.MemberDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository {
    MemberDto save(MemberDto memberDto);
    Optional<MemberDto> findById(Long id);
    Optional<MemberDto> findByEmail(String email);
    List<MemberDto> findAll();
}
