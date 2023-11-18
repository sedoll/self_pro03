package kr.co.teaspoon;

import kr.co.teaspoon.dto.Sample;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LombokTest {
    private static final Logger log = LoggerFactory.getLogger("kr.co.teaspoon.LombokTest.class");

    @BeforeClass
    public static void testClassStart() {
        log.info("테스트 시작");
    }

    @AfterClass
    public static void testClassEnd() {
        log.info("테스트 종료");
    }
    
    @Before
    public void testjunitStart() {
        log.info("junit 시작");
    }


    @Test
    public void testLombok() {
        Sample dto = new Sample();
        dto.setNo(1);
        dto.setName("김기태");
        System.out.println(dto);
        System.out.println(dto.getNo());
        System.out.println(dto.getName());

        // 로그로 출력
        log.info(dto.toString());
    }

    @Test
    public void testLombok2() {
        Sample dto = new Sample();
        dto.setNo(2);
        dto.setName("홍길동");
        System.out.println(dto);
        System.out.println(dto.getNo());
        System.out.println(dto.getName());

        // 로그로 출력
        log.info(dto.toString());
    }

    @After
    public void testjunitEnd() {
        log.info("junit 종료");
    }
}
