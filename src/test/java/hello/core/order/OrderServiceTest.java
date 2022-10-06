package hello.core.order;

import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepositoryForMemory;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

class OrderServiceTest {

    MemberRepositoryForMemory memberRepository = new MemberRepositoryForMemory();
    OrderService orderService = new OrderServiceImpl(memberRepository, new RateDiscountPolicy());

    @Test
    void createOrder() {
        // given
        Long memberId = 1L;
        Member member = new Member(memberId, "'memberA", Grade.VIP);
        memberRepository.save(member);
        int itemPrice = 1000;
        String itemName = "itemA";

        // when
        Order order = orderService.createOrder(memberId, itemName, itemPrice);

        // then
        assertThat(order.getDiscountPrice(), is(equalTo(100)));
    }
}