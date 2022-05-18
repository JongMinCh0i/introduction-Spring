package introduction.introductionSpring.repository;


import introduction.introductionSpring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


// Interface를 만들어 놓으면 Spring JPA가 JpaRepository에 구현체를 만들어 놓는다. 그리고 Spring bean에 등록함
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}