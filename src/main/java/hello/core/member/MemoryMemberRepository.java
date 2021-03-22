package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); // 컨커러트? 동시성 이슈가 있을 수 있음

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    } //원래는 오류처리 해야됨

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}

