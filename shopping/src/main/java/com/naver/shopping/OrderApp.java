package com.naver.shopping;

import com.naver.shopping.member.Grade;
import com.naver.shopping.member.Member;
import com.naver.shopping.member.MemberService;
import com.naver.shopping.member.MemberServiceImpl;
import com.naver.shopping.order.Order;
import com.naver.shopping.order.OrderService;
import com.naver.shopping.order.OrderServiceImpl;
/*
//Test 폴더 쓰기 전에 테스트함
public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        Long memberId = 1L;
        Member member = new Member(memberId, "test1", Grade.BASIC);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "USB", 24900);
        System.out.println("order= " + order);
    }
}
*/


