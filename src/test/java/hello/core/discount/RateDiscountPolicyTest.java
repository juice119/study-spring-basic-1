package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용된다.")
    void vip_o() {
        // given
        Member member = new Member(1L, "member_VIP", Grade.VIP);
        int price = 1000;

        //when
        int discountPrice = rateDiscountPolicy.discount(member, price);

        //then
        assertThat(discountPrice,is(equalTo(1000 / 10)));
    }

    @Test
    @DisplayName("VIP가 아니면  할인이 적용되지 않는다.")
    void vip_x() {
        // given
        Member member = new Member(1L, "member_VIP", Grade.BASIC);
        int price = 1000;

        //when
        int discountPrice = rateDiscountPolicy.discount(member, price);

        //then
        assertThat(discountPrice,is(equalTo(0)));

    }
}