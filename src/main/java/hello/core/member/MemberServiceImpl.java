package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public static MemberServiceImpl useMemory() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    @Override
    public void join(Member member) {
        this.memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return this.memberRepository.findById(memberId);
    }

    public MemberRepository getMemberRepository() {
        return this.memberRepository;
    }
}
