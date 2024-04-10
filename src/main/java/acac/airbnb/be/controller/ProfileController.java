package acac.airbnb.be.controller;

import acac.airbnb.be.domain.ProfileDto;
import acac.airbnb.be.service.PorfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class ProfileController {

    private final PorfileService porfileService;

    @GetMapping("/profiles/{id}")
    public ProfileDto profile(@PathVariable Long id){
        return  porfileService.findOne(id)
                .orElseThrow(() -> new RuntimeException("프로필을 찾을 수 없음")); // 프로필이 존재하지 않으면 예외 발생
    }
}