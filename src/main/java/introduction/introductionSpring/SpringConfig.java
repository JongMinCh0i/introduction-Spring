package introduction.introductionSpring;

import introduction.introductionSpring.repository.MemberRepository;
import introduction.introductionSpring.repository.MemoryMemberRepository;
import introduction.introductionSpring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository(); // 구현체 (인터페이스를 구현한 클래스)
    }
}
