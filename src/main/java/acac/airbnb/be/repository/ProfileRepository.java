package acac.airbnb.be.repository;

import acac.airbnb.be.domain.ProfileDto;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository {
    Optional<ProfileDto> findById(Long id);
    List<ProfileDto> findAll();
}
