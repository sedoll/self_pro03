package kr.co.teaspoon.test;

import kr.co.teaspoon.dto.Person;
import kr.co.teaspoon.dto.Sample;
import org.springframework.context.support.GenericXmlApplicationContext;

public class IoCTest {
    public static void main(String[] args) {
        GenericXmlApplicationContext factory = new GenericXmlApplicationContext("GenericXmlApplicationContext.xml");
        Person person = (Person) factory.getBean("person");
        Sample sam2 = (Sample) factory.getBean("sam2");

        System.out.println(person);
        System.out.println(person.getSample().getNo());
        System.out.println(person.getSample().getName());
        System.out.println(person.getTel());
        System.out.println(sam2);
        System.out.println(sam2.getNo());
        System.out.println(sam2.getName());
    }
}
