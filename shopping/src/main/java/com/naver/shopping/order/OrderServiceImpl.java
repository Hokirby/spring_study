package com.naver.shopping.order;

import com.naver.shopping.discount.RateDiscountPolicy;
import com.naver.shopping.member.Member;
import com.naver.shopping.member.MemberRepository;
import com.naver.shopping.member.MemoryMemberRepository;
import com.naver.shopping.discount.DiscountPolicy;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    /*
    //@RequiredArgsConstructor 로 대체됨
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("subDiscountPolicy") DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    */

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findByID(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId,itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
