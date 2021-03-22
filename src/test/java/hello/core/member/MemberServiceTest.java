package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl(); //추상화와 구체화ㅡㄹ 모두 의존함. DIP
    @Test
    void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then (찾아서 검증)
        Assertions.assertThat(member).isEqualTo(findMember); // 찾은 member랑 member랑 같은지
    }
}
