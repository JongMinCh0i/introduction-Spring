package introduction.introductionSpring;

import introduction.introductionSpring.aop.TimeTraceAop;
import introduction.introductionSpring.repository.*;
import introduction.introductionSpring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean // Bean 등록
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
}