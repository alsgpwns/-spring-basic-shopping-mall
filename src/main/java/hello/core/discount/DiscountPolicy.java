package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    // return 할인 대상 금액액 (할인 금액을 return할거임)
   int discount(Member member, int price);
}
