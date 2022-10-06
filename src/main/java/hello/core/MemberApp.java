package hello.core;

import hello.core.member.*;

public class MemberApp {
    public static void main(String[] args) {
        MemberServiceImpl memberService = MemberServiceImpl.useMemory();
        Member tester = new Member(1L, "tester", Grade.BASIC);
        memberService.join(tester);

        Member findMember = memberService.findMember(tester.getId());
        System.out.println("new Member Id= " + tester.getName());
        System.out.println("find Member Id= " + findMember.getName());
    }
}
