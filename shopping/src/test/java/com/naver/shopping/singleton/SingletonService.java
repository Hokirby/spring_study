package com.naver.shopping.singleton;

public class SingletonService {
    //1. static 객체 1개 생성
    private static final SingletonService instance = new SingletonService();
    //2. public static 메소드 생성, 객체 인스턴스는 이 메소드로만 조회 가능
    public static SingletonService getInstance() {
        return instance;
    }
    //3. 생성자를 private 로 선언해서 외부에서 new 키워드를 사용한 객체 생성 못하게함
    private SingletonService() {
    }
    //임의로 호출 잘 되는지 확인하기 위한 메서드
    public void logic() {
        System.out.println("실행 성공 !");
    }
}
