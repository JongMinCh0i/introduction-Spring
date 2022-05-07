package introduction.introductionSpring.controller;

import introduction.introductionSpring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
// Spring Container에서 Spring bean 이 관리된다.
//
public class MemberController {

    private final MemberService memberService;

    @Autowired // (자동연결)
    // 생성자 호출시 멤버 서비스를 스프링이 스프링 컨테이너에 있는 멤버 서비스를 연결해줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
