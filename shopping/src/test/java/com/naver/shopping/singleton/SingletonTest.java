package com.naver.shopping.singleton;

import com.naver.shopping.AppConfig;
import com.naver.shopping.member.MemberRepository;
import com.naver.shopping.member.MemberService;
import com.naver.shopping.member.MemberServiceImpl;
import com.naver.shopping.order.OrderServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {
    @Test
    @DisplayName("Container with no Spring")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        //1. 조회: 호출할 때마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();
        //2. 조회: 호출할 때마다 객체를 생성
        MemberService memberService12 = appConfig.memberService();
        //참조값 다른 것 확인
        System.out.println("memberService1= " + memberService1);
        System.out.println("memberService2= " + memberService12);

        assertThat(memberService1).isNotSameAs(memberService12);
    }

    @Test
    @DisplayName("Object using with Singleton pattern")
    public void singletonServiceTest() {
        /*
        //컴파일 오류
        SingletonService singletonService = new SingletonService();
        */
        //1. 조회: 호출할 때 마다 같은 객체를 반환
        SingletonService singletonService1 = SingletonService.getInstance();
        //2. 조회: 호출할 때 마다 같은 객체를 반환
        SingletonService singletonService2 = SingletonService.getInstance();
        //참조값이 같은 것 확인
        System.out.println("singletonService1= " + singletonService1);
        System.out.println("singletonService2= " + singletonService2);
        assertThat(singletonService1).isSameAs(singletonService2);
        singletonService1.logic();;
        singletonService2.logic();
    }

    @Test
    @DisplayName("Spring Container with Singleton")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //1. 조회: 호출할 때 마다 같은 객체를 반환
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        //2. 조회: 호출할 때 마다 같은 객체를 반환
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);
        //참조값이 같은 것 확인
        System.out.println("memberService1= " + memberService1);
        System.out.println("memberService2= " + memberService2);
        assertThat(memberService1).isSameAs(memberService2);
    }

    @Test
    @DisplayName("Complex new processes in Configuration")
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
        //모두 같은 인스턴스(참조값)인지 확인
        System.out.println("memberService -> memberRepository= " + memberService.getMemberRepository());
        System.out.println("orderService -> memberRepository= " + orderService.getMemberRepository());
        System.out.println("memberRepository= " + memberRepository);
        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }
}
