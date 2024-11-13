package com.naver.shopping.member;

import com.naver.shopping.AppConfig;
import com.naver.shopping.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();

    @Test
    void join() {
        Member member = new Member(1L, "test1", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        Assertions.assertThat(member) .isEqualTo(findMember);
    }

    /*
    //잘못된 테스트 예시
    @Test
    void failedTest () {
        Member member1 = new Member(1L, "test1", Grade.VIP);
        Member member2 = new Member(2L, "test2", Grade.BASIC);

        Assertions.assertThat(member1).isEqualTo(member2);
    }
     */
}
