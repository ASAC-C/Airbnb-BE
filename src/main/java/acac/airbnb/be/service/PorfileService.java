package acac.airbnb.be.service;

import acac.airbnb.be.domain.ProfileDto;
import acac.airbnb.be.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PorfileService {
    private final ProfileRepository profileRepository;

    public List<ProfileDto> findProfiles(){
        System.out.println("서비스 로그: " + profileRepository.findAll());
        return profileRepository.findAll();
    }

    public Optional<ProfileDto> findOne(Long profileId){
        return profileRepository.findById(profileId);
    }
}
