package acac.airbnb.be.controller.member;

import acac.airbnb.be.controller.MemberForm;
import acac.airbnb.be.controller.ResultDto;
import acac.airbnb.be.domain.MemberDto;
import acac.airbnb.be.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController //객체를 HTTP 응답 본문으로 직접 반환
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public ResponseEntity<MemberDto> create(@RequestBody MemberForm form) {
        MemberDto memberDto = MemberDto.of(form);
        memberService.createUser(memberDto);
        System.out.println(ResponseEntity.ok(memberDto));
        return ResponseEntity.ok(memberDto);
    }


    @GetMapping("/members")
    public String list(Model model){
        List<MemberDto> memberDtos = memberService.findMembers(); //모든 멤버 가져옴
        model.addAttribute("members", memberDtos); //view에 주입
        return "members/memberList";
    }
}