package hello.core;

import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.OrderService;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Member tester = new Member(1L, "tester", Grade.BASIC);
        memberService.join(tester);

        Member findMember = memberService.findMember(tester.getId());
        Order order = orderService.createOrder(findMember.getId(), "testItem", 1000);

        System.out.println("new Member Id= " + tester.getName());
        System.out.println("find Member Id= " + findMember.getName() + "order = " + order.toString());

    }
}
