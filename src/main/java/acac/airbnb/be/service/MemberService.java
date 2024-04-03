package acac.airbnb.be.service;

import acac.airbnb.be.domain.Member;
import acac.airbnb.be.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member){
        validateDuplicateMember(member);
        Member savedMember = memberRepository.save(member);
        return savedMember.getId();
    }

    private void validateDuplicateMember(Member member){
        memberRepository.findByEmail(member.getEmail())
                .ifPresent(m ->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }//반환하는 값이 List이기 때문에 findAll 수행 후 그냥 반환해주면 됨.

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
