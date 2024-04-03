package acac.airbnb.be.controller;

import acac.airbnb.be.domain.Member;
import acac.airbnb.be.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController //객체를 HTTP 응답 본문으로 직접 반환
@CrossOrigin(origins = "http://localhost:3000")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(@RequestBody MemberForm form){// JSON 형식으로 데이터를 전송, 이를 Spring 컨트롤러에서 자바 객체로 변환

        Member member = new Member(); //member 생성
        //여기서 sout으로 확인할 것
        System.out.println(form.getUser_name());
        member.setUserName(form.getUser_name()); //이름 주입
        member.setUserLastName(form.getUser_last_name()); //성 주입
        member.setBirthDay(form.getBirth_day()); //생년월일 주입
        member.setEmail(form.getEmail()); //이메일 주입(중복 검증, 중복 시 예외 발생)
        member.setPassword(form.getPassword()); // 비밀번호 주입
        //입력하는 값 다 하나씩 찍으면서 확인

        memberService.join(member); // 여기서 중복 이메일 캐ㅍ

        return "redirect:http://localhost:3000"; // 회원가입이 끝나면
    }


    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers(); //모든 멤버 가져옴
        model.addAttribute("members",members); //view에 주입
        return "members/memberList";
    }
}
