package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


// main method를 이용한 test code (별로 좋지 않음)
public class OrderApp {
    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig(); // 변경
//        MemberService memberService = appConfig.memberService(); // 변경
//        OrderService orderService = appConfig.orderService(); // 변경

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext((AppConfig.class));
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "ItemA", 10000);
        System.out.println("order = "+order);
        System.out.println("order = "+ order.caluatePrice());
    }
}
