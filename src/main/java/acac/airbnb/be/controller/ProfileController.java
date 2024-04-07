package acac.airbnb.be.controller;

import acac.airbnb.be.domain.ProfileDto;
import acac.airbnb.be.service.PorfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ProfileController {

    private final PorfileService porfileService;

    @GetMapping("/profiles/{id}")
    public String profile(@PathVariable Long id, Model model){
        ProfileDto profileDto = porfileService.findOne(id)
                .orElseThrow(() -> new RuntimeException("프로필을 찾을 수 없음")); // 프로필이 존재하지 않으면 예외 발생
        System.out.println("컨트롤러 로그: " + profileDto);
        model.addAttribute("profile", profileDto); // 단일 프로필을 모델에 추가
        return "profileList"; // 상세 정보를 보여줄 템플릿 이름
    }

}
