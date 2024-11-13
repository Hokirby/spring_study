package com.naver.shopping.order;

import com.naver.shopping.AppConfig;
import com.naver.shopping.member.Grade;
import com.naver.shopping.member.Member;
import com.naver.shopping.member.MemberService;
import com.naver.shopping.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderServiceTest {
    /*
    //스프링 사용으로 사용 안하는 코드
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();
    */
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberService = ac.getBean("memberService", MemberService.class);
    OrderService orderService = ac.getBean("orderService", OrderService.class);

    /*
    //첫번째 사용
    @Test
    void order () {
        Member member = new Member(1L, "test1", Grade.VIP);
        memberService.join(member);
        Order findOrder = orderService.createOrder(1L, "USB", 24900);

        Assertions.assertThat(findOrder.getDiscountPrice()).isEqualTo(2490);
    }
     */
    /*
    //AppConfig 만들고 사용
    @Test
    void orderFixed() {
        long memberId = 1L;
        Member member = new Member(memberId, "test1", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "USB", 24900);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
     */

    @Test
    void orderPercent() {
        long memberId = 1L;
        Member member = new Member(memberId, "test1", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "USB", 24900);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(2490);
    }
}
