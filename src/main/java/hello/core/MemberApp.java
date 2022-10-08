package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);


        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);


        Member tester = new Member(1L, "tester", Grade.BASIC);
        memberService.join(tester);

        Member findMember = memberService.findMember(tester.getId());
        Order order = orderService.createOrder(findMember.getId(), "testItem", 1000);

        System.out.println("new Member Id= " + tester.getName());
        System.out.println("find Member Id= " + findMember.getName() + "order = " + order.toString());

    }
}
