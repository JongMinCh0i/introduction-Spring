package introduction.introductionSpring.service;

import introduction.introductionSpring.domain.Member;
import introduction.introductionSpring.repository.MemberRepository;
import introduction.introductionSpring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;


// Service 클래스의 method name 은 bussiness logic 과 연괸되는 이름으로 설정하는 것이 유지보수에 용의함

// command + shift + t (해당 클래스의 testclass 생성 )
public class MemberService {

    private final MemberRepository memberRepository;
    // DI
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원X
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    // 단축키(  command + option + M : Extract Method 설정 (validateDuplicateMember) )
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    /**
     * 회원가입
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}