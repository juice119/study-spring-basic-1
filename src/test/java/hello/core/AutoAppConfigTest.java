package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class AutoAppConfigTest {
    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = ac.getBean(MemberService.class);
        MemberRepository memberRepository = ac.getBean("memoryMemberRepository", MemberRepository.class);

        assertThat(memberService).isInstanceOf(MemberService.class);
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }
}