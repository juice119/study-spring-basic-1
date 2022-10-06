package hello.core.member;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;


class MemberServiceImplTest {

    MemberService memberService;

    @BeforeEach
    void beforeEach() {
        this.memberService = MemberServiceImpl.useMemory();
    }

    @Test
    void join() {
        // given
        Member member = new Member(1L, "tester", Grade.BASIC);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(member.getId());

        // then
        assertThat(member, is(equalTo(findMember)));
    }
}
