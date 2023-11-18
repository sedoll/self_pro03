package kr.co.teaspoon;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// 비밀번호 암호화
public class BcryptTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
        String s = pwEncoder.encode("1234");
        System.out.println(s);
    }
}
