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
        Optional<ProfileDto> profileDto = porfileService.findOne(id);
        System.out.println("컨트롤러 로그:" + profileDto);
        model.addAttribute("profile", profileDto);
        return "profileList.html";
    }

}
