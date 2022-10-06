package hello.core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    private MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public static MemberServiceImpl useMemory() {
        return new MemberServiceImpl(new MemberRepositoryForMemory());
    }

    @Override
    public void join(Member member) {
        this.memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return this.memberRepository.findById(memberId);
    }
}
