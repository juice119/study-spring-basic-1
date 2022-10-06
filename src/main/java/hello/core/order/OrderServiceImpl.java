package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemberRepositoryForMemory;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemberRepositoryForMemory();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);

        return new Order(memberId, itemName, itemPrice, discountPolicy.discount(member, itemPrice));
    }
}
