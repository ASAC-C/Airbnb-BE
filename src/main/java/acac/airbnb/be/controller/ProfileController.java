package acac.airbnb.be.controller;

import acac.airbnb.be.domain.ProfileDto;
import acac.airbnb.be.service.PorfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProfileController {

    private final PorfileService porfileService;

    @GetMapping("/profiles")
    public String profile(Model model){
        List<ProfileDto> profileDtos = porfileService.findProfiles();
        System.out.println("컨트롤러 로그:" + profileDtos);
        model.addAttribute("profiles", profileDtos);
        return "profileList.html";
    }

}
