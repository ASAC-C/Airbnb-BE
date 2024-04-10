package acac.airbnb.be.controller.member;

import acac.airbnb.be.controller.MemberForm;
import acac.airbnb.be.domain.MemberDto;
import acac.airbnb.be.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Slf4j //로깅을 위한 어노테이션, 로깅을 사용하지는 않습니다.
@RestController //객체를 HTTP 응답 본문으로 직접 반환
@RequiredArgsConstructor//final 필드 생성자를 위한 어노테이션
public class MemberController {
    private final MemberService memberService; //DI를 통한 의존성 주입

    /**
     * 스프링 thymeleaf로 테스트할 떄 사용, 회원 가입 양식을 반환
    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm"; //view를 직접 반환
    }*/

    /**
     * @param form
     * @return 예시 <200 OK OK,acac.airbnb.be.domain.MemberDto@1deba83f,[]>
     */
    @PostMapping("/members/new")
    public ResponseEntity<MemberDto> create(@RequestBody MemberForm form) {
        MemberDto memberDto = MemberDto.of(form); //MemberForm으로 프론트에서 받은 객체를 Dto 객체로 변환
        memberService.createUser(memberDto);
//        System.out.println(ResponseEntity.ok(memberDto)); //테스트를 위한 sout
        return ResponseEntity.ok(memberDto);
    }


    /**
     * 스프링 thymeleaf로 테스트할 떄 사용, 저장된 모든 회원 목록을 반환
    @GetMapping("/members")
    public String list(Model model){
        List<MemberDto> memberDtos = memberService.findMembers(); //모든 멤버 가져옴
        model.addAttribute("members", memberDtos); //view에 주입
        return "members/memberList";
    }
    */
}