package com.naver.shopping.member;

import org.springframework.stereotype.Component;


public interface MemberService {
    void join (Member member);
    Member findMember (Long memberId);
}
