package com.naver.shopping;

import com.naver.shopping.discount.DiscountPolicy;
import com.naver.shopping.discount.FixDiscountPolicy;
import com.naver.shopping.discount.RateDiscountPolicy;
import com.naver.shopping.member.MemberRepository;
import com.naver.shopping.member.MemberService;
import com.naver.shopping.member.MemberServiceImpl;
import com.naver.shopping.member.MemoryMemberRepository;
import com.naver.shopping.order.OrderService;
import com.naver.shopping.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy () {
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService() {
        //new MemoryMemberRepository() 가 진행된다
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        //new MemoryMemberRepository() 가 진행된다
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
